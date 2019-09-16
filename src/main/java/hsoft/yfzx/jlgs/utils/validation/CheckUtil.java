package hsoft.yfzx.jlgs.utils.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * 数据校验类
 *
 * <p>detailed comment
 * @author YLJ 2015-5-21
 * @see
 * @since 1.0
 */
public class CheckUtil
{

    /**
     * 判断字符串是否为空
     * 
     * @param str
     * @return
     */
    public static boolean isEmpty(String str)
    {
        if (str == null || "".equals(str.trim()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 分页-跳转至使用
     * 
     * @param str
     * @return
     */
    public static boolean goToPage(String str)
    {
        if (str == null || "".equals(str))
        {
            return true;
        }
        String pattern = "^[0-9]*$";
        if (str.trim().matches(pattern))
        {
            if (Integer.parseInt(str) > 0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return true;
        }
    }

    /**
     * 判断是否存在特殊字符
     * 
     * @param str
     * @return  true表示包含特殊字符,false不包含
     */
    public static boolean hasSpecialChar(String str)
    {
        if (isEmpty(str))
        {
            return false;
        }
        
        String regEx="[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）――+|{}【】‘；：”“’。，、？\\\\　]";  
        regEx="['\"#$　\\\\]+";   
        Pattern   p   =   Pattern.compile(regEx);      
        Matcher   m   =   p.matcher(str.trim());      
        if(m.find())
        {
            return true;
        }
        return false;
    }
    /**
     * 判断是否存在不合法字符，str将用来拼做SQL语句中的Where条件，此处主要是检查是否包含百分号
     * @param str
     * @return
     */
    public static boolean isWhere(String str)
    {
        if(str.indexOf("%") != -1)
        {
            return false;
        }
        return true;
    }
    /**
     * 邮政编码
     * 
     * @param str
     * @return
     */
    public static boolean checkPostNum(String str)
    {
        if (isEmpty(str))
        {
            return false;
        }
        String pattern = "^[0-9]\\d{5}$";
        if (str.trim().matches(pattern))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 固定电话
     * 
     * @param str
     * @return
     */
    public static boolean checkTelNum(String str)
    {
        if (isEmpty(str))
        {
            return false;
        }
        //3-4位区号，7-8位直播号码，1－4位分机号
        String pattern = "^(\\d{7,8})|(\\d{4}|\\d{3})\\-(\\d{7,8})|(\\d{4}|\\d{3})\\-(\\d{7,8})\\-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})\\-(\\d{4}|\\d{3}|\\d{2}|\\d{1})$";
        if (str.trim().matches(pattern))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 移动电话
     * 格式：(86)1xxxxxxxxxx,(+86)1xxxxxxxxxx,1xxxxxxxxxx
     * @param str
     * @return
     */
    public static boolean checkMobileNum(String str)
    {
        if (isEmpty(str))
        {
            return false;
        }
        String pattern = "^((\\+?86)|(\\(\\+86\\)))?1\\d{10}$"; 
        if (str.trim().matches(pattern))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 校验座机号码或移动号码
     * @param str
     * @return  true有效,false无效
     */
    public static boolean checkPhoneNum(String str)
    {
        if(checkTelNum(str) || checkMobileNum(str))
        {
            return true;
        }
        return false;
    }
    
    
    /**
     * 判断身份证号的合法性
     * @param civilIdNumber 公民身份号码
     * @return boolean 是否合法
     */
    public static boolean checkCivilIdNum(String civilIdNumber)
    {        
        if (civilIdNumber.length() != 15 && civilIdNumber.length() != 18)
        {
            return false;
        }
        String pattern = "^\\d{15}$|^\\d{17}(?:\\d|x|X)$"; 
        if (civilIdNumber.trim().matches(pattern))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Email
     * 
     * @param str
     * @return
     */
    public static boolean checkEmail(String str)
    {
        if (isEmpty(str))
        {
            return false;
        }
        String pattern = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$";
        if (str.trim().matches(pattern))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * QQ
     * 
     * @param str
     * @return
     */
    public static boolean checkQQ(String str)
    {
        if (isEmpty(str))
        {
            return false;
        }
        String pattern = "^[1-9]*[1-9][0-9]*$";
        if (str.trim().matches(pattern))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * IP
     * 
     * @param str
     * @return
     */
    public static boolean checkIP(String str)
    {
        if (isEmpty(str))
        {
            return false;
        }
        
        String pattern = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."  
                +"(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."  
                +"(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."  
                +"(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        
        if (str.trim().matches(pattern))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 验证是否是数字
     * 
     * @param str
     * @return
     */
    public static boolean isNum(String str)
    {
        if (isEmpty(str))
        {
            return false;
        }
        String pattern = "^(0)|([1-9]\\d*)$";
        if (str.trim().matches(pattern))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    /**
     * 是否为小数
     * 
     * @param str
     * @return
     */
    public static boolean isDouble(String str)
    {
        if (isEmpty(str))
        {
            return false;
        }
        String pattern = "^-?([1-9]\\d*|[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*|0?\\.0+|0)$";
        if (str.trim().matches(pattern))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 校验字符串长度
     * 
     * @param value
     * @param length
     * @return
     */
    public static boolean checkLength(String value, int length)
    {
        if (isEmpty(value))
        {
            return false;
        }
        if (value.trim().length() > length)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 校验日期合法性
     * 
     * @param date
     * @return
     */
    public static boolean checkDate(String date, String format)
    {
        if (isEmpty(date))
        {
            return false;
        }
        String pattern = "";
        if ("YYYY-MM-DD".equals(format))
        {
            // 下面是YYYY-MM-DD
            pattern = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]{1}((((0?[13578])|(1[02]))[\\-\\/\\s]{1}((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]{1}((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]{1}((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]{1}((((0?[13578])|(1[02]))[\\-\\/\\s]{1}((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]{1}((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]{1}((0?[1-9])|(1[0-9])|(2[0-8]))))))$";
        }
        else if ("YYYYMMDD".equals(format))
        {
            // 下面是：YYYYMMDD
            pattern = "^((\\d{2}(([02468][048])|([13579][26]))((((0?[13578])|(1[02]))((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))((0?[1-9])|([1-2][0-9])|(30)))|(0?2((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))((((0?[13578])|(1[02]))((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))((0?[1-9])|([1-2][0-9])|(30)))|(0?2((0?[1-9])|(1[0-9])|(2[0-8]))))))$";
            
        }
        else
        {
            return true;
        }
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(date); // 实例化 Matcher 类
        if (m.matches())
        {
            String tmp = date.replaceAll("\\-", "");
            Long dateLong = Long.parseLong(tmp);
            if (dateLong >= 19000101 && dateLong <= 30000101)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    /**
     * 可校验"YYYYMMDD hh:mm:ss"或"YYYY-MM-DD hh:mm:ss"两种格式
     * @param date
     * @return
     */
    public boolean checkDateTime(String date)
    {
        if (isEmpty(date))
        {
            return false;
        }
        //可校验"YYYYMMDD hh:mm:ss"或"YYYY-MM-DD hh:mm:ss"两种格式
        String pattern = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
        
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(date); // 实例化 Matcher 类
        if (m.matches())
        {
            String tmp = date.replaceAll("\\-", "");
            Long dateLong = Long.parseLong(tmp);
            if (dateLong >= 19000101 && dateLong <= 30000101)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    
    /**
     * 校验输入数字
     * 
     * @param str 传入字符串
     * @return 验证通过返回true
     */
    public static boolean limitNum(String str)
    {
        String regex = "^[0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(str);
        boolean flag = match.matches();
        return flag;
    }
    
    /**
     * 只校验输入汉字
     * 
     * @param str 传入字符串
     * @return 验证通过返回true
     */
    public static boolean isChinese(String str)
    {
        String regex = "^[\u4E00-\u9FA5]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(str);
        boolean flag = match.matches();
        return flag;
    }

    /**
     * 校验输入字母数字
     * 
     * @param str 传入字符串
     * @return 验证通过返回true
     */
    public static boolean isLetterNum(String str)
    {
        String regex = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(str);
        boolean flag = match.matches();
        return flag;
    }
    
    /**
     * 票据号规则
     * 校验输入字母数字减号
     * 
     * @param str 传入字符串
     * @return 验证通过返回true
     */
    public static boolean isBillNum(String str)
    {
        String regex = "^[a-zA-Z0-9-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(str);
        boolean flag = match.matches();
        return flag;
    }
    /**
     * 校验输入字母
     * 
     * @param str 传入字符串
     * @return 验证通过返回true
     */
    public static boolean isLetter(String str)
    {
        String regex = "^[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(str);
        boolean flag = match.matches();
        return flag;
    }
    
    /**
     * 校验数量(销售模块用),根据药品单位,如果是克,则可以输入两位小数,如果不是克,则需输入整数
     * @param str
     * @param maxIntLength  整数位长度
     * @param decimalLength 小数位长度
     * @return 验证通过返回true
     */
    public static boolean isDecimal(String str, int maxIntLength, int decimalLength)
    {
        String regex = "";
        if(decimalLength > 0)
        {
            regex = "^([+])?\\d{0,"+maxIntLength+"}(\\.\\d{0,"+decimalLength+"})?$";
        }
        else
        {
            regex = "^([+])?\\d{0,"+maxIntLength+"}$";
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(str);
        boolean flag = match.matches();
        return flag;
    }
}
