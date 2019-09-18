package hsoft.yfzx.jlgs.utils.model.http;

/**
 * 请求返回参数
 * @param <T>
 */
public class HsoftRstData<T> {

    private int code;

    private String message;

    private String developmentError;

    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDevelopmentError() {
        return developmentError;
    }

    public void setDevelopmentError(String developmentError) {
        this.developmentError = developmentError;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
