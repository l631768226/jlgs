package hsoft.yfzx.jlgs.business.basic.ctmmodel;

/**
 * 校验token返回具体信息
 */
public class QCheckResult {

    //结果信息
    private String resultCode;

    //提示信息
    private String info;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
