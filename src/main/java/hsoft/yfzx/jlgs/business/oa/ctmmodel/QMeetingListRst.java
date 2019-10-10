package hsoft.yfzx.jlgs.business.oa.ctmmodel;

/**
 * 会议列表返回信息model
 */
public class QMeetingListRst {

    private String id;

    private String type;

    private String title;

    private String name;

    private String state;

    private String startTime;

    private String finishTime;

    private String meetingroom;

    private String host;

    private String hostName;

    private String createDep;

    private String createBy;

    private String createDate;

    private String flags;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeetingroom() {
        return meetingroom;
    }

    public void setMeetingroom(String meetingroom) {
        this.meetingroom = meetingroom;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getCreateDep() {
        return createDep;
    }

    public void setCreateDep(String createDep) {
        this.createDep = createDep;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
