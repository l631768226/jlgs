package hsoft.yfzx.jlgs.business.basic.ctmmodel;

/**
 * 校验token接口返回参数
 */
public class QCheckTokenRst {

    //有效的token
    private String token = "";
    //校验token具体结果信息
    private QCheckResult xmppResult = new QCheckResult();

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public QCheckResult getXmppResult() {
        return xmppResult;
    }

    public void setXmppResult(QCheckResult xmppResult) {
        this.xmppResult = xmppResult;
    }
}
