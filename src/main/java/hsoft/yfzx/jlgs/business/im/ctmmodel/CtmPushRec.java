package hsoft.yfzx.jlgs.business.im.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;

import java.util.List;

/**
 * 消息推送接口传入参数
 */
public class CtmPushRec extends AbstactBaseRec {
    //用户名列表
    private List<String> userNameList;
    //IMEI列表
    private List<String> IMEIList;
    //发送内容
    private String content;
    //APNS推送标题
    private String apnsTitle;
    //APNS推送对话框内容
    private String apnsContent;

    public List<String> getUserNameList() {
        return userNameList;
    }

    public void setUserNameList(List<String> userNameList) {
        this.userNameList = userNameList;
    }

    public List<String> getIMEIList() {
        return IMEIList;
    }

    public void setIMEIList(List<String> IMEIList) {
        this.IMEIList = IMEIList;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getApnsTitle() {
        return apnsTitle;
    }

    public void setApnsTitle(String apnsTitle) {
        this.apnsTitle = apnsTitle;
    }

    public String getApnsContent() {
        return apnsContent;
    }

    public void setApnsContent(String apnsContent) {
        this.apnsContent = apnsContent;
    }
}
