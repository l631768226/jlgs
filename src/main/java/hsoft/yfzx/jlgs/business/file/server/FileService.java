package hsoft.yfzx.jlgs.business.file.server;

import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.gridfs.GridFSDBFile;
import hsoft.yfzx.jlgs.business.file.ctmmodel.CFileUploadRst;
import hsoft.yfzx.jlgs.business.file.ctmmodel.QFileDetailRec;
import hsoft.yfzx.jlgs.business.file.ctmmodel.QFileDetailRst;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Value("${custom.fileUrl}")
    private String baseUrl;

    /**
     * 文件上传
     * @param request
     * @return
     */
    public ResponseData<List<CFileUploadRst>> uploadFile(HttpServletRequest request) {
        ResponseData<List<CFileUploadRst>> responseData = new ResponseData<>();
        String result = "error";
        String value = request.getParameter("json");

        String userId = (String) request.getAttribute("userId");
        List<CFileUploadRst> resultList = new ArrayList<>();
        System.out.println("the value = " + value);
        try {

            /**
             * Servlet3.0新增了request.getParts()/getPart(String filename) api，
             * 用于获取使用multipart/form-data格式传递的http请求的请求体， 通常用于获取上传文件。
             */
            // Part part = request.getPart("file");
            Collection<Part> parts = request.getParts();
            Iterator<Part> it = parts.iterator();

            result = "";
            while (it.hasNext()) {
                Part tmpPart = it.next();
                if (tmpPart.getSubmittedFileName() == null) {
                    continue;
                }
                System.out.println("######" + tmpPart.getSubmittedFileName() + "," + tmpPart.getSize());
                if (tmpPart.getName().equals("file") && tmpPart.getSize() > 0) {
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

        } catch (IOException e) {
            e.printStackTrace();
            responseData.setStatus(ReturnStatus.ERR0029);
            responseData.setResultSet(resultList);
            return responseData;
        } catch (ServletException e) {
            e.printStackTrace();
            responseData.setStatus(ReturnStatus.ERR0029);
            responseData.setResultSet(resultList);
            return responseData;
        }
        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(resultList);
        return responseData;
    }

    /**
     * 查询文件详情
     * @param data
     * @return
     */
    public ResponseData<QFileDetailRst> queryFileDetail(QFileDetailRec data) {
        ResponseData<QFileDetailRst> responseData = new ResponseData<>();

        // 获取文件存储id
        String fileId = data.getFileId();
        // 根据文件id查询
        Query query = Query.query(Criteria.where("_id").is(fileId));
        // 查询单个文件
        GridFSFile gfsfile = gridFsTemplate.findOne(query);
        // 文件不存在时返回
        if (gfsfile == null) {
            responseData.setStatus(ReturnStatus.ERR0003);
            responseData.setExtInfo("文件不存在");
            return responseData;
        }
        QFileDetailRst qFileDetailRst = new QFileDetailRst();
        qFileDetailRst.setFileId(fileId);
        qFileDetailRst.setFileName(gfsfile.getFilename());
        qFileDetailRst.setMD5(gfsfile.getMD5());
        qFileDetailRst.setLength(String.valueOf(gfsfile.getLength()));
        qFileDetailRst.setVisityUrl(baseUrl + fileId);
        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qFileDetailRst);

        return responseData;
    }

    /**
     * 文件下载
     * @param filename
     * @param id
     * @param response
     * @throws IOException
     */
    public void downloadfile(String filename, String id, HttpServletResponse response)
            throws IOException {
        /**
         * 关于Query的具体用发下面的链接给的很清楚了，这里就不多说了。
         *
         * @link{http://www.baeldung.com/queries-in-spring-data-mongodb}
         */
        // Query query = Query.query(Criteria.where("filename").is(filename));
        Query query = Query.query(Criteria.where("_id").is(id));
        // 查询单个文件
        GridFSFile gfsfile = gridFsTemplate.findOne(query);

        if (gfsfile != null) {
            // 通知浏览器进行文件下载

            String as = gfsfile.getFilename();
            // String fileName = as;// = java.net.URLEncoder.encode(as,
            // "UTF-8");
            /* 根据request的locale 得出可能的编码，中文操作系统通常是gb2312 */
            // fileName = new String(as.getBytes("utf8"), "ISO_8859_1");
            as = new String(as.getBytes("utf8"), "ISO_8859_1");

            response.setHeader("Content-Disposition", "attachment;filename=" + as);

            System.out.println(response.getHeaderNames() + response.getHeader("X-Application-Context")
                    + response.getHeader("Transfer-Encoding"));

            InputStream inputStream = null;
            ServletOutputStream outputStream = null;

            try {
                GridFsResource gridFsResource = gridFsTemplate.getResource(gfsfile);

                inputStream = gridFsResource.getInputStream();
                byte bs[]=new byte[1024];
                outputStream = response.getOutputStream();
                while (inputStream.read(bs)>0){
                    outputStream.write(bs);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                inputStream.close();

                outputStream.close();
            }
        }

    }

    /**
     * 即时通讯用的文件上传
     *
     * @param part
     * @return
     */
    public String uploadDBFile(Part part) {
        String result = "error";
        try {

            // 获得提交的文件名
            String filename = part.getSubmittedFileName();

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
