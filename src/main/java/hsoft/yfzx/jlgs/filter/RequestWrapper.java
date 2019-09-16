package hsoft.yfzx.jlgs.filter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class RequestWrapper extends HttpServletRequestWrapper
{
    private String requestBody = null;

    HttpServletRequest req = null;

    private Map<String, String[]> params;

    public RequestWrapper(HttpServletRequest request)
    {
        super(request);
        this.req = request;
    }

    public RequestWrapper(HttpServletRequest request, String requestBody)
    {
        super(request);
        this.requestBody = requestBody;
        this.req = request;
    }
    public RequestWrapper(HttpServletRequest request, String requestBody, Map<String, String[]> newParams)
    {
        super(request);
        this.requestBody = requestBody;
        this.req = request;
        this.params = newParams;
    }

    @Override
    public BufferedReader getReader() throws IOException
    {
        return new BufferedReader(new StringReader(requestBody));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException
    {
        return new ServletInputStream()
        {
            private InputStream in = new ByteArrayInputStream(requestBody.getBytes(req.getCharacterEncoding()));

            @Override
            public int read() throws IOException
            {
                return in.read();
            }

            @Override
            public boolean isFinished()
            {
                return false;
            }

            @Override
            public boolean isReady()
            {
                return false;
            }

            @Override
            public void setReadListener(ReadListener listener)
            {

            }

        };
    }

    public Map<String, String[]> getParameterMap()
    {
        return params;
    }

    public Enumeration<String> getParameterNames()
    {
        Vector<String> l = new Vector<String>(params.keySet());
        return l.elements();
    }

    public String[] getParameterValues(String name)
    {
        Object v = params.get(name);
        if (v == null)
        {
            return null;
        }
        else if (v instanceof String[])
        {
            return (String[]) v;
        }
        else if (v instanceof String)
        {
            return new String[]
            { (String) v };
        }
        else
        {
            return new String[]
            { v.toString() };
        }
    }

    public String getParameter(String name)
    {
        Object v = params.get(name);
        if (v == null)
        {
            return null;
        }
        else if (v instanceof String[])
        {
            String[] strArr = (String[]) v;
            if (strArr.length > 0)
            {
                return strArr[0];
            }
            else
            {
                return null;
            }
        }
        else if (v instanceof String)
        {
            return (String) v;
        }
        else
        {
            return v.toString();
        }
    }
}
