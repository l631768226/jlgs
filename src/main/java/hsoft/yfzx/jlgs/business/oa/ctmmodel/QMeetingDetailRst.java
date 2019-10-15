package hsoft.yfzx.jlgs.business.oa.ctmmodel;

import java.util.List;

/**
 * 查询会议详情返回model
 */
public class QMeetingDetailRst {

    private String id;

    private String type;

    private String title;

    private String name;

    private String startTime;

    private String finishTime;

    private String meetingRoom;

    private String host;

    private String hostName;

    private String createDep;

    private String meetingMaterial;

    private String meetingAttachment;

    private String leaderAttend;

    private String deputy;

    private String deputyName;

    private String offlineAttachment;

    private String state;

    private String createBy;

    private String createDate;

    private String flags;

    private String isLeader;

    private List<QTopicListRst> topicList;

    public String getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(String isLeader) {
        this.isLeader = isLeader;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
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

    public List<QTopicListRst> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<QTopicListRst> topicList) {
        this.topicList = topicList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
