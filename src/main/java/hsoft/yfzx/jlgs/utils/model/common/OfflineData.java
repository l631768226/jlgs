package hsoft.yfzx.jlgs.utils.model.common;

/**
 * 离线通讯录下载返回的实体类
 * @param <T>
 */
public class OfflineData<T> {
    //返回的通讯录数据
    private T data;
    //返回数据中的最大版本时间戳
    private String versionStamp;
    //本次下载时间
    private String downloadTime;

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

    public String getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(String downloadTime) {
        this.downloadTime = downloadTime;
    }
}
