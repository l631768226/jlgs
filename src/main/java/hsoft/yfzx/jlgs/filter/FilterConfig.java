package hsoft.yfzx.jlgs.filter;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "custom.filter")
public class FilterConfig
{
    public static class Exclude
    {
        private List<String> urlpattern;

        public List<String> getUrlpattern()
        {
            return urlpattern;
        }

        public void setUrlpattern(List<String> urlpattern)
        {
            this.urlpattern = urlpattern;
        }
    }
    private Exclude exclude; 
    private List<String> method;

    public List<String> getMethod()
    {
        if(method != null) 
        {
            for(int i = 0; i < method.size();i++) 
            {
             // 全部变成大写
                method.set(i, method.get(i).toUpperCase());
            }
        }
        return method;
    }

    public void setMethod(List<String> method)
    {
        this.method = method;
    }


    public Exclude getExclude()
    {
        return exclude;
    }

    public void setExclude(Exclude exclude)
    {
        this.exclude = exclude;
    }

    public List<String> getExcludeUrlpattern()
    {
        if(this.exclude != null && this.exclude.getUrlpattern() != null) 
        {
            for(int i = 0; i < this.exclude.getUrlpattern().size();i++) 
            {
                // 全部变成大写
                this.exclude.getUrlpattern().set(i, this.exclude.getUrlpattern().get(i).toUpperCase());
            }
            return this.exclude.getUrlpattern();
        }
        
        return null;
    }

}
