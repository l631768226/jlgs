package hsoft.yfzx.jlgs.utils.model.http;

/**
 * 请求参数
 * @param <T>
 */
public class HsoftReqData<T> {

    private T changeableData;

    public T getChangeableData() {
        return changeableData;
    }

    public void setChangeableData(T changeableData) {
        this.changeableData = changeableData;
    }
}
