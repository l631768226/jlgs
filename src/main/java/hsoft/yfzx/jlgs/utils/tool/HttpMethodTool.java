package hsoft.yfzx.jlgs.utils.tool;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 网络请求方法类
 */
public class HttpMethodTool {

    /**
     * 发送HTTP请求获取json字符串
     * @param url 请求地址
     * @param content 请求数据
     * @param method 请求方法（POST GET）
     * @return 结果json字符串
     */
    public static String getJson(String url, String content, String method) {
        try {
            URL mUrl = new URL(url);
            HttpURLConnection mHttpURLConnection = (HttpURLConnection) mUrl.openConnection();
            //设置链接超时时间
            mHttpURLConnection.setConnectTimeout(15000);
            //设置读取超时时间
            mHttpURLConnection.setReadTimeout(15000);
            //设置请求参数
            mHttpURLConnection.setRequestMethod(method);
            //添加Header
            mHttpURLConnection.setRequestProperty("Connection", "Keep-Alive");

            mHttpURLConnection.setRequestProperty("Content-type", "application/json; charset=utf-8");
            //接收输入流
            mHttpURLConnection.setDoInput(true);
            //传递参数时需要开启
            mHttpURLConnection.setDoOutput(true);
            //Post方式不能缓存,需手动设置为false
            mHttpURLConnection.setUseCaches(false);

            mHttpURLConnection.connect();

            if(content != null && !"".equals(content)){

                DataOutputStream dos = new DataOutputStream(mHttpURLConnection.getOutputStream());

                String postContent = content;

                dos.write(postContent.getBytes("UTF-8"));
                dos.flush();
                // 执行完dos.close()后，POST请求结束
                dos.close();
            }
            // 获取代码返回值
            int respondCode = mHttpURLConnection.getResponseCode();

            if (respondCode == 200) {
                // 获取响应的输入流对象
                InputStream is = mHttpURLConnection.getInputStream();
                // 创建字节输出流对象
                ByteArrayOutputStream message = new ByteArrayOutputStream();
                // 定义读取的长度
                int len = 0;
                // 定义缓冲区
                byte buffer[] = new byte[1024];
                // 按照缓冲区的大小，循环读取
                while ((len = is.read(buffer)) != -1) {
                    // 根据读取的长度写入到os对象中
                    message.write(buffer, 0, len);
                }
                // 释放资源
                is.close();
                message.close();
                // 返回字符串
                String msg = new String(message.toByteArray(),"UTF-8");
                return msg;
            }
            return "fail";
        }catch(Exception e){
            return "error";
        }
    }

}
