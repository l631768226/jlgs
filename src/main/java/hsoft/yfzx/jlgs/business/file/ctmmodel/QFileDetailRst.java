package hsoft.yfzx.jlgs.business.file.ctmmodel;

public class QFileDetailRst {

    // 文件id
    private String fileId;

    // 文件名
    private String fileName;

    private String fileType;
    // 文件MD5值
    private String MD5;

    private String length;

    private String visityUrl;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getMD5() {
        return MD5;
    }

    public void setMD5(String MD5) {
        this.MD5 = MD5;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getVisityUrl() {
        return visityUrl;
    }

    public void setVisityUrl(String visityUrl) {
        this.visityUrl = visityUrl;
    }
}
