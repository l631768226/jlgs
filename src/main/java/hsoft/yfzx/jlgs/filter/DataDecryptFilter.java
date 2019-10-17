package hsoft.yfzx.jlgs.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hsoft.yfzx.jlgs.utils.tool.FBase64;
import org.jivesoftware.smack.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;

@Order(1)
@Configuration
@WebFilter(filterName = "dataDecryptFilter", urlPatterns = "/*")
@Conditional(DecryptFilterCondition.class)
public class DataDecryptFilter extends OncePerRequestFilter
{
    @Autowired
    private FilterConfig filterConfig;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException
    {
        //获取请求地址
    	String servletPath = request.getServletPath();
        String method = request.getMethod();
        List<String> excludeUrlPatterns = filterConfig.getExcludeUrlpattern();
        List<String> methods = filterConfig.getMethod();

        response.setHeader("Access-Control-Allow-Origin", "*");
        // 允许的访问方法
        response.setHeader("Access-Control-Allow-Methods","POST, GET, PUT, OPTIONS, DELETE, PATCH");
        // Access-Control-Max-Age 用于 CORS 相关配置的缓存
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers","token,Origin, X-Requested-With, Content-Type, Accept");
        
        if (excludeUrlPatterns == null || methods == null)
        {
            methods = new ArrayList<String>();
            // 默认只处理POST和GET事件
            methods.add("POST");
            methods.add("GET");
            excludeUrlPatterns = new ArrayList<String>();
        }
        // 进行处理
        if (!isInExcludeUrl(excludeUrlPatterns,servletPath.toUpperCase()))
        {
            // 进行过滤
            if (methods.contains(method.toUpperCase()))
            {
                String clearText = "";
                String ciphertext = "";
                // 只对配置的http method进行处理，例如"POST"或"GET"
                if(request.getContentType() != null && request.getContentType().indexOf("multipart/form-data") == -1) 
                {
                    // 文件上传时，request中的part数量会大于0.此时，不能从request中读body，否则会异常
                    // 此处是part数量等于0，可以读取request中的post数据
                    // 获取请求的数据，一般为密文的形式,即密文
                    ciphertext = getRequestBody(request);
                    if (StringUtils.isNotEmpty(ciphertext))
                    {
                        // 对密文进行解码，即明文
                        clearText = new String(FBase64.decode(ciphertext), request.getCharacterEncoding());
                    }
                }
                
                // 对于Form表单提交的数据，也需要进行解密
                Map<String, String[]> parameterMap = request.getParameterMap();
                Map<String,String[]> clearParameterMap = new HashMap<String, String[]>(request.getParameterMap());
                if (parameterMap.size() > 0)
                {
                    // 对parameter数据进行解密
                    // 获取key的集合
                    Set<String> keySet = parameterMap.keySet();
                    // 遍历全部的key
                    Iterator<String> it = keySet.iterator();
                    // 开始遍历
                    String key;
                    while (it.hasNext())
                    {
                        // 取得key
                        key = it.next();
                        
                        // 根据key 取出数据
                        String[] data = parameterMap.get(key);
                        StringBuffer sb = new StringBuffer();
                        for(int i = 0; i < data.length; i++){
                            sb. append( data[i] + ", ");
                        }
                     
                        String ns = sb.toString();
                         
//                        System.out.println("the key = " + key + " , the data = " + ns);
                        // 循环遍历并解密全部数据
                        for (int i = 0; i < data.length; i++)
                        {
                            if(StringUtils.isNotEmpty(data[i])) 
                            {
                                // 解密
                                data[i] = new String(FBase64.decode(data[i]), request.getCharacterEncoding());
                            }
                        }
                        // 将解完密的数据，替换回map中
                        clearParameterMap.put(key, data);
                    }
                    // 遍历结束
                }

                // 通过包装类，将解码后的明文，回写到request对象中，替换原有的密文
                ResponseWrapper responseWrapper = new ResponseWrapper(response);
                RequestWrapper requestWrapper = new RequestWrapper(request, clearText, clearParameterMap);

                // 转到下一个过滤链
                // filterChain.doFilter(wrapRequest, wrapResponse);
                super.doFilter(requestWrapper, responseWrapper, filterChain);

                // 将返回结果，进行转码(加密)
                byte[] data = responseWrapper.getResponseData();
                ciphertext = FBase64.encode(data);
                response.setContentLength(ciphertext.getBytes("UTF-8").length);
                // 将加密后的结果，写入响应
                writeResponse(response, ciphertext);
            }
        }
        else
        {
            // 对于需要例外的url，不进行过滤处理
            // 直接跳过
            filterChain.doFilter(request, response);
            return;
        }
    }

    /**
     * 从Request中读取数据
     * @param req
     * @return
     */
    private String getRequestBody(HttpServletRequest req)
    {
        try
        {
            BufferedReader reader = req.getReader();
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                sb.append(line);
            }
            String json = sb.toString();
            return json;
        }
        catch (IOException e)
        {
            System.out.println("验签时请求体读取失败");
        }
        return "";
    }

    private void writeResponse(ServletResponse response, String responseString) throws IOException
    {
        PrintWriter out = response.getWriter();
        out.print(responseString);
        out.flush();
        out.close();
    }
    private boolean isInExcludeUrl(List<String> excludeUrlPatterns,String url) 
    {
        if(excludeUrlPatterns == null) 
        {
            return false;
        }
        if(url.indexOf("?")!= -1) 
        {
            url = url.substring(0,url.indexOf("?"));
        }
        
        // 用于判断url是/aa/bb/cc?key=value的形式，与/aa/bb/cc/*是否匹配的规则
        // 主要是用于处理/aa/bb/*中的星号通配符问题
        for(String excludeUrl : excludeUrlPatterns) 
        {
            if(excludeUrl.equals("/*")) 
            {
                return true;
            }
            if(excludeUrl.endsWith("/*")) 
            {
                excludeUrl = excludeUrl.substring(0,excludeUrl.lastIndexOf("/*")+1);
                if(url.startsWith(excludeUrl)) 
                {
                    return true;
                }
            }
            if(excludeUrl.equalsIgnoreCase(url)) 
            {
                return true;
            }
        }
        return false;
    }
}
