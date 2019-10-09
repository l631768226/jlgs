package hsoft.yfzx.jlgs.business.basic.ctmmodel;

import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

/**
 * check token 接口传入参数
 */
public class QCheckTokenRec extends AbstactBaseRec {

    //用户id
    @DataValidation(description = "用户id", dataType = DataType.STRING, required = true, length = 36)
    private String userId;

    //登录设备
    @DataValidation(description = "登录设备", dataType = DataType.STRING, required = true, length = 8)
    private String deviceType;
    //IMEI
    private String IMEI = "";
    //是否踢人操作 0否 1是
    @DataValidation(description = "是否解决冲突", dataType = DataType.STRING, required = false, length = 3)
    private String kick;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public String getKick() {
        return kick;
    }

    public void setKick(String kick) {
        this.kick = kick;
    }
}
