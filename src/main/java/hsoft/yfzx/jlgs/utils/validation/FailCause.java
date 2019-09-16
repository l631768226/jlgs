package hsoft.yfzx.jlgs.utils.validation;

public class FailCause
{
    private String tag;
    
    private String desc;
    
    private String cause;

    public FailCause(String tag,String desc,String cause) 
    {
        this.tag = tag;
        this.desc = desc;
        this.cause = cause;
    }
    
    public String getTag()
    {
        return tag;
    }

    public void setTag(String tag)
    {
        this.tag = tag;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public String getCause()
    {
        return cause;
    }

    public void setCause(String cause)
    {
        this.cause = cause;
    }
    
}
