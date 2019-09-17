package hsoft.yfzx.jlgs.business.im.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;

import java.util.List;

public class QChatStoreListRec extends AbstactBaseRec {

    private List<String> userIds;

    private List<String> groupIds;

    private String userId;

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    public List<String> getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(List<String> groupIds) {
        this.groupIds = groupIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
