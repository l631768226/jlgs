package hsoft.yfzx.jlgs.business.oa.model;

public class Notice {
    private String id;

    private String type;

    private String relation_ID;

    private String title;

    private String content;

    private String state;

    private String create_BY;

    private String create_DATE;

    private String del_flag;

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

    public String getRelation_ID() {
        return relation_ID;
    }

    public void setRelation_ID(String relation_ID) {
        this.relation_ID = relation_ID;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag;
    }
}