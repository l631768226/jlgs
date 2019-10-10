package hsoft.yfzx.jlgs.business.oa.ctmmodel;

/**
 * 未上会议题列表查询返回model
 */
public class QMeetingNoTopicRst {

    private String title;

    private String topicId;

    private String createDepName;

    private String createDep;

    private String reporter;

    private String countersignName;

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreateDepName() {
        return createDepName;
    }

    public void setCreateDepName(String createDepName) {
        this.createDepName = createDepName;
    }

    public String getCreateDep() {
        return createDep;
    }

    public void setCreateDep(String createDep) {
        this.createDep = createDep;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getCountersignName() {
        return countersignName;
    }

    public void setCountersignName(String countersignName) {
        this.countersignName = countersignName;
    }
}
