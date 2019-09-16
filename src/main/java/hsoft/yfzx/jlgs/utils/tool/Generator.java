package hsoft.yfzx.jlgs.utils.tool;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * 
 * 生成工具集
 *
 * <p>
 * 用于生成各种码或主键
 * @author YLJ 2017年8月7日
 * @since 1.0
 */
public class Generator
{
    private final static String stab = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static Random rnd = new Random();
    
    private static DateTimeFormatter DATE_FORMAT_LONG = DateTimeFormat.forPattern("yyyyMMddHHmmss");

    private static DateTimeFormatter DATE_FORMAT_STANDARD = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    private static DateTimeFormatter DATE_FORMAT_CHINESE = DateTimeFormat.forPattern("yyyy年MM月dd日 HH时mm分ss秒");
    
    private static DateTimeFormatter TIMESTAMP_FORMAT_LONG = DateTimeFormat.forPattern("yyyyMMddHHmmssSSS");
    
    private static DateTimeFormatter DAY_FORMAT_LONG = DateTimeFormat.forPattern("yyyyMMdd");
    
    private static DateTimeFormatter DATE_FORMAT_LONG12 = DateTimeFormat.forPattern("yyyyMMddHHmm");

    /**
     * 获取指定上限的随机正整型数
     * @param u 上限
     * @return
     */
    public static int getRInt(int u)
    {
        int rInt = rnd.nextInt();
        return (Math.abs(rInt%u));
    }
    
    /**
     * 获取指定长度的随机字符串
     * @param len
     * @return
     */
    public static String getRStr(int len)
    {
        StringBuffer sb = new StringBuffer();
        int slen = stab.length() - 1;
        for (int i = 0; i < len; i++)
        {
            int pos = getRInt(slen);
            sb.append(stab.charAt(pos));
        }
        return sb.toString();
    }
    /**
     * 生成带前缀的随机序列号
     * @param prefix  序列号的前半部分
     * @return
     */
    public synchronized static String createSerialNumber(String  prefix)
    {
        String suffix = getLongTimeStamp()+getRStr(7);
        String serialNumber = prefix + "_" + suffix;
        return serialNumber;
    }
    /**
     * 生成随机的UUID码
     * @return 长度36位
     */
    public static String getUUID()
    {
        return UUID.randomUUID().toString();
    }
    
    public static String getToken() 
    {
        String token = UUID.randomUUID().toString();
        token = token.replaceAll("-", "");
        return token;
    }

    /**
     * 生成17位long型时间戳
     * @return
     */
    public static Long getLongTimeStamp() 
    {
        String strNow = DateTime.now().toString(TIMESTAMP_FORMAT_LONG);
        return Long.parseLong(strNow);
    }
    
    public static Long getLongDayTimeStamp(){
        String strDay = DateTime.now().toString(DAY_FORMAT_LONG);
        return Long.parseLong(strDay);
    }
    
    /**
     * 生成年月日的BigDecimal格式 8位
     * @return
     */
    public static BigDecimal getDecimalDay(){
        return BigDecimal.valueOf(getLongDayTimeStamp());
    }
    
    /**
     * 
     * @return 格式YYYYMMddHHmmssSSS,17位
     */
    public static BigDecimal getDecimalTimeStamp() 
    {
        return BigDecimal.valueOf(getLongTimeStamp());
    }
    
    /**
     * 获取服务器当前时间
     * @return 格式YYYYMMddHHmmss,14位
     */
    public static long getCurrentLongTime()
    {
        String strNow = DateTime.now().toString(DATE_FORMAT_LONG);
        return Long.parseLong(strNow);
    }
    /**
     * 获取服务器当前时间
     * @return 格式YYYYMMddHHmmss,14位
     */
    public static BigDecimal getCurrentTime() 
    {
        return new BigDecimal(getCurrentLongTime());
    }
    /**
     * 获取服务器当前时间
     * @return 格式yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentStandardTime()
    {
        return DateTime.now().toString(DATE_FORMAT_STANDARD);
    }
    /**
     * 获取服务器当前时间
     * @return 格式yyyy年MM月dd日 HH时mm分ss秒
     */
    public static String getCurrentChineseTime()
    {
        return DateTime.now().toString(DATE_FORMAT_CHINESE);
    }
    
    /**
     * 获取服务器当前时间
     * @return 格式YYYYMMddHHmmss,12位
     */
    public static long getCurrentLongTime12()
    {
        String strNow = DateTime.now().toString(DATE_FORMAT_LONG12);
        return Long.parseLong(strNow);
    }
    
    /**
     * 获取服务器当前时间
     * @return 格式YYYYMMddHHmm,12位
     */
    public static BigDecimal getCurrentTime12() 
    {
        return new BigDecimal(getCurrentLongTime12());
    }
    
    public static void main(String[] args)
    {
        System.out.println(Generator.getUUID());
        System.out.println(Generator.getUUID());
        System.out.println(Generator.getLongTimeStamp());
        System.out.println(Generator.getCurrentLongTime());
        System.out.println(Generator.getCurrentStandardTime());
        System.out.println(Generator.getCurrentChineseTime());
        
        DateTime dateTime = DateTime.now();
//        dateTime = dateTime.plusDays(-1);
        System.out.println(dateTime.toString("yyyyMMdd000000"));
        
        long now = getCurrentLongTime();
        DateTime dt = DateTime.parse(String.valueOf(now), DATE_FORMAT_LONG);
        System.out.println(dt.toString(DATE_FORMAT_STANDARD));
        dt = dt.plusDays(1);
        System.out.println(dt.toString(DATE_FORMAT_STANDARD));
        System.out.println("--------------------");
        System.out.println(getToken());
        System.out.println("--------------------");
        Map<String,String> map = new HashMap<String,String>();
        for(int i = 0; i < 1000;i++) 
        {
            map.put(createSerialNumber("KQ_QJ"), "");
            System.out.println(createSerialNumber("KQ_QJ"));
        }
        System.out.println(map.size());
        
    }
}
