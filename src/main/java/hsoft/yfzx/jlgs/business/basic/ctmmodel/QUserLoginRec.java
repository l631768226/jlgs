package hsoft.yfzx.jlgs.business.basic.ctmmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;
import hsoft.yfzx.jlgs.utils.validation.DataType;
import hsoft.yfzx.jlgs.utils.validation.DataValidation;

public class QUserLoginRec extends AbstactBaseRec {

    @DataValidation(description = "用户名", dataType = DataType.STRING, required = true, length = 30)
    private String userName;

    @DataValidation(description = "密码", dataType = DataType.STRING, required = true, length = 30)
    private String password;
    @DataValidation(description = "设备类型", dataType = DataType.STRING, required = true, length = 8)
    private String deviceType;

    @DataValidation(description = "IMEI", dataType = DataType.STRING, length = 50)
    @JsonProperty("IMEI")
    private String IMEI;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
