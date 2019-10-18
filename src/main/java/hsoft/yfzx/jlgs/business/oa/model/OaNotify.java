package hsoft.yfzx.jlgs.business.oa.model;

public class OaNotify {
    private String id;

    private String type;

    private String title;

    private String content;

    private String files;

    private String status;

    private String create_BY;

    private String create_DATE;

    private String update_BY;

    private String update_DATE;

    private String remarks;

    private String del_FLAG;

    private String notice_TYPE;

    private String notice_ID;

    private String realname;

    private String people;

    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreate_BY() {
        return create_BY;
    }

    public void setCreate_BY(String create_BY) {
        this.create_BY = create_BY;
    }

    public String getCreate_DATE() {
        return create_DATE;
    }

    public void setCreate_DATE(String create_DATE) {
        this.create_DATE = create_DATE;
    }

    public String getUpdate_BY() {
        return update_BY;
    }

    public void setUpdate_BY(String update_BY) {
        this.update_BY = update_BY;
    }

    public String getUpdate_DATE() {
        return update_DATE;
    }

    public void setUpdate_DATE(String update_DATE) {
        this.update_DATE = update_DATE;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDel_FLAG() {
        return del_FLAG;
    }

    public void setDel_FLAG(String del_FLAG) {
        this.del_FLAG = del_FLAG;
    }

    public String getNotice_TYPE() {
        return notice_TYPE;
    }

    public void setNotice_TYPE(String notice_TYPE) {
        this.notice_TYPE = notice_TYPE;
    }

    public String getNotice_ID() {
        return notice_ID;
    }

    public void setNotice_ID(String notice_ID) {
        this.notice_ID = notice_ID;
    }
}