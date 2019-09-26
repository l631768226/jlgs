package hsoft.yfzx.jlgs.business.oa.ctmmodel;

import java.util.List;

/**
 * 查询会议详情返回model
 */
public class QMeetingDetailRst {

    private String meetingId;

    private String type;

    private String name;

    private String start;

    private String finish;

    private String meetingRoom;

    private String host;

    private String createDept;

    private String meetingMaterial;

    private String meetingAttachment;

    private String leaderAttend;

    private String deputy;

    private String deputyName;

    private String offlineAttachment;

    private String state;

    private String create_by;

    private String create_date;

    private List<QTopicListRst> topics;

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(String meetingRoom) {
        this.meetingRoom = meetingRoom;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getCreateDept() {
        return createDept;
    }

    public void setCreateDept(String createDept) {
        this.createDept = createDept;
    }

    public String getMeetingMaterial() {
        return meetingMaterial;
    }

    public void setMeetingMaterial(String meetingMaterial) {
        this.meetingMaterial = meetingMaterial;
    }

    public String getMeetingAttachment() {
        return meetingAttachment;
    }

    public void setMeetingAttachment(String meetingAttachment) {
        this.meetingAttachment = meetingAttachment;
    }

    public String getLeaderAttend() {
        return leaderAttend;
    }

    public void setLeaderAttend(String leaderAttend) {
        this.leaderAttend = leaderAttend;
    }

    public String getDeputy() {
        return deputy;
    }

    public void setDeputy(String deputy) {
        this.deputy = deputy;
    }

    public String getDeputyName() {
        return deputyName;
    }

    public void setDeputyName(String deputyName) {
        this.deputyName = deputyName;
    }

    public String getOfflineAttachment() {
        return offlineAttachment;
    }

    public void setOfflineAttachment(String offlineAttachment) {
        this.offlineAttachment = offlineAttachment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public List<QTopicListRst> getTopics() {
        return topics;
    }

    public void setTopics(List<QTopicListRst> topics) {
        this.topics = topics;
    }
}
