package hsoft.yfzx.jlgs.business.file.controller;

import hsoft.yfzx.jlgs.business.file.ctmmodel.CFileUploadRst;
import hsoft.yfzx.jlgs.business.file.ctmmodel.QFileDetailRec;
import hsoft.yfzx.jlgs.business.file.ctmmodel.QFileDetailRst;
import hsoft.yfzx.jlgs.business.file.server.FileService;
import hsoft.yfzx.jlgs.utils.model.common.RequestData;
import hsoft.yfzx.jlgs.utils.model.common.ResponseData;
import hsoft.yfzx.jlgs.utils.model.common.ReturnStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 文件上传接口
     * @param request
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseData<List<CFileUploadRst>> uploadFile(HttpServletRequest request){
        return fileService.uploadFile(request);
    }

    /**
     * 文件下载接口
     * @param filename 文件名
     * @param id 文件id
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/download", method = {RequestMethod.POST, RequestMethod.GET})
    public void downloadfile(@RequestParam(name = "fname", required = false) String filename, @RequestParam(name = "id", required = true) String id,
                      HttpServletResponse response) throws Exception{
        fileService.downloadfile(filename, id, response);
    }

    /**
     * 根据文件id查询文件详细信息
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/detail", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseData<QFileDetailRst> fileDetail(@RequestBody RequestData<QFileDetailRec> requestData){
        ResponseData<QFileDetailRst> responseData = new ResponseData<>();

        QFileDetailRec data = requestData.getData();

        if (!data.validation()) {
            // 数据校验没有通过
            responseData.setStatus(ReturnStatus.ERR0001);
            responseData.setExtInfo(data.getFailCauses());
            // 返回
            return responseData;
        }

        return fileService.queryFileDetail(data);
    }


    @RequestMapping(value = "/pic", method = {RequestMethod.POST, RequestMethod.GET})
    public void downloadPic(@RequestParam(name = "id", required = true) String id, HttpServletResponse response){
        fileService.downloadPic(id, response);
    }

}
