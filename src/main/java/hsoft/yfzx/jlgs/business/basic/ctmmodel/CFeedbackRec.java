package hsoft.yfzx.jlgs.business.basic.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

/**
 * 用户反馈传入参数
 */
public class CFeedbackRec extends AbstactBaseRec {

    @DataValidation(description = "类型", dataType = DataType.STRING, required = true, length = 3)
    private String type;

    @DataValidation(description = "内容", dataType = DataType.STRING, required = true, length = 255)
    private String content;

    @DataValidation(description = "用户邮箱", dataType = DataType.STRING, required = false, length = 50)
    private String email;

    @DataValidation(description = "用户电话", dataType = DataType.STRING, required = false, length = 20)
    private String phone;

    @DataValidation(description = "用户类型", dataType = DataType.STRING, required = true, length = 3)
    private String userType;

    @DataValidation(description = "照片", dataType = DataType.STRING, required = false, length = 255)
    private String photo;

    @DataValidation(description = "用户id", dataType = DataType.STRING, required = false, length = 36)
    private String userId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
