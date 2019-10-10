package hsoft.yfzx.jlgs.business.oa.ctmmodel;

import java.util.List;

public class QMeetingApproveDetailRst {

    private String proInsId;

    private String userId;

    private String position;

    private String approveState;

    private String opinion;

    private String realName;

    private String type;

    private String name;

    private String startTime;

    private String finishTime;

    private String meetingRoom;

    private String host;

    private String hostName;

    private String deputy;

    private String submasterNames;

    private String deptName;

    private List<QMeetingTopicRst> topicList;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getProInsId() {
        return proInsId;
    }

    public void setProInsId(String proInsId) {
        this.proInsId = proInsId;
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

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getDeputy() {
        return deputy;
    }

    public void setDeputy(String deputy) {
        this.deputy = deputy;
    }

    public String getSubmasterNames() {
        return submasterNames;
    }

    public void setSubmasterNames(String submasterNames) {
        this.submasterNames = submasterNames;
    }

    public List<QMeetingTopicRst> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<QMeetingTopicRst> topicList) {
        this.topicList = topicList;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getApproveState() {
        return approveState;
    }

    public void setApproveState(String approveState) {
        this.approveState = approveState;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}
