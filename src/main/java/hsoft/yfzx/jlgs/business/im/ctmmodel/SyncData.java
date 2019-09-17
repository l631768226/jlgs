package hsoft.yfzx.jlgs.business.im.ctmmodel;

/**
 * 同步信息使用的model
 * @param <T>
 * @param <K>
 */
public class SyncData<T, K> {

    private T data;

    private String versionStamp;

    private String syncTime;

    private K removeData;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getVersionStamp() {
        return versionStamp;
    }

    public void setVersionStamp(String versionStamp) {
        this.versionStamp = versionStamp;
    }

    public String getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(String syncTime) {
        this.syncTime = syncTime;
    }

    public K getRemoveData() {
        return removeData;
    }

    public void setRemoveData(K removeData) {
        this.removeData = removeData;
    }
}
