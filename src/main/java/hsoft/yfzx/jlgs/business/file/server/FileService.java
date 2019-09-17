package hsoft.yfzx.jlgs.business.file.server;

import com.mongodb.gridfs.GridFSFile;
import hsoft.yfzx.jlgs.business.file.ctmmodel.CFileUploadRst;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    public ResponseData<List<CFileUploadRst>> uploadFile(HttpServletRequest request) {
        ResponseData<List<CFileUploadRst>> responseData = new ResponseData<>();
        String result = "error";
        String value = request.getParameter("json");

        String userId = (String) request.getAttribute("userId");
        List<CFileUploadRst> resultList = new ArrayList<>();
        System.out.println("the value = " + value);
        try
        {

            /**
             * Servlet3.0新增了request.getParts()/getPart(String filename) api，
             * 用于获取使用multipart/form-data格式传递的http请求的请求体， 通常用于获取上传文件。
             */
            // Part part = request.getPart("file");
            Collection<Part> parts = request.getParts();
            Iterator<Part> it = parts.iterator();

            result = "";
            while (it.hasNext())
            {
                Part tmpPart = it.next();
                if (tmpPart.getSubmittedFileName() == null)
                {
                    continue;
                }
                System.out.println("######" + tmpPart.getSubmittedFileName() + "," + tmpPart.getSize());
                if (tmpPart.getName().equals("file") && tmpPart.getSize() > 0)
                {
                    // result += saveFile2MongoDB(tmpPart) + "\r\n\r\n";
                    // 获得提交的文件名
                    String filename = tmpPart.getSubmittedFileName();
                    // 获得文件输入流
                    InputStream ins = tmpPart.getInputStream();
                    // 获得文件类型
                    String contenttype = tmpPart.getContentType();
                    // 将文件存储到mongodb中,mongodb 将会返回这个文件的具体信息

                    ObjectId resultId = gridFsTemplate.store(ins, filename, contenttype);
                    result = resultId.toString();
                    System.out.println("文件id为: " + result);
                    CFileUploadRst cFileUploadRst = new CFileUploadRst();
                    cFileUploadRst.setFileId(result);
                    resultList.add(cFileUploadRst);
                }
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
            responseData.setStatus(ReturnStatus.ERR0029);
            responseData.setResultSet(resultList);
            return responseData;
        }
        catch (ServletException e)
        {
            e.printStackTrace();
            responseData.setStatus(ReturnStatus.ERR0029);
            responseData.setResultSet(resultList);
            return responseData;
        }
        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(resultList);
        return responseData;
    }

    public String uploadDBFile(Part part) {
        String result = "error";
        try {

            // 获得提交的文件名
            String filename =part.getSubmittedFileName();

            // 获得文件输入流
            InputStream ins = part.getInputStream();
            // 获得文件类型
            String contenttype = part.getContentType();
            // 将文件存储到mongodb中,mongodb 将会返回这个文件的具体信息
            ObjectId fileId = gridFsTemplate.store(ins, filename, contenttype);
            result = fileId.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
