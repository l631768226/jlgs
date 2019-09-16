package hsoft.yfzx.jlgs.business.basic.ctmmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import hsoft.yfzx.jlgs.utils.validation.AbstactBaseRec;

public class UUserMobileInfoRec extends AbstactBaseRec {

    private String deviceType;

    @JsonProperty("IMEI")
    private String IMEI;

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
