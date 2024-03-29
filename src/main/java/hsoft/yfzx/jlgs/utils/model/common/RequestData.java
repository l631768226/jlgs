package hsoft.yfzx.jlgs.utils.model.common;

public class RequestData<T>
{
    /**
     * 登录标识
     */
    private String token;

    /**
     * 经度
     */
    private String lon;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 速度
     */
    private String vel;
    
    /**
     * 当前用户信息
     */
    private Owner owner;
    /**
     * 请求数据
     */
    private T data;

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public String getLon()
    {
        return lon;
    }

    public void setLon(String lon)
    {
        this.lon = lon;
    }

    public String getLat()
    {
        return lat;
    }

    public void setLat(String lat)
    {
        this.lat = lat;
    }

    public String getVel()
    {
        return vel;
    }

    public void setVel(String vel)
    {
        this.vel = vel;
    }
    
    public Owner getOwner()
    {
        return owner;
    }

    public void setOwner(Owner owner)
    {
        this.owner = owner;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        if (data == null)
            return;
        this.data = data;
    }
}
