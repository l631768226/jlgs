package hsoft.yfzx.jlgs.utils.validation;

/**
 * 
 * 数据校验时，用到的数据类型标识
 *
 * <p>对应情况，见下表:
 * <table border='1'>
 * <tr>
 * <td>标识</td><td>说明</td>
 * </tr>
 * <tr><td>STRING</td><td>字符串</td></tr>
 * <tr><td>INTEGER</td><td>整数</td></tr>
 * <tr><td>DECIMAL</td><td>精度数值</td></tr>
 * <tr><td>DATE</td><td>日期</td></tr>
 * <tr><td>LETTER</td><td>字母</td></tr>
 * <tr><td>LETTER_NUM</td><td>字母+数字</td></tr>
 * <tr><td>CHINESE</td><td>中文</td></tr>
 * <tr><td>TEL_NUM</td><td>固定电话</td></tr>
 * <tr><td>POST_NUM</td><td>邮编</td></tr>
 * <tr><td>MOBILE_NUM</td><td>移动电话</td></tr>
 * <tr><td>EMAIL</td><td>email</td></tr>
 * <tr><td>IP</td><td>IP地址</td></tr>
 * <tr><td>BILL_NUM</td><td>票据号</td></tr>
 * <tr><td>WHERE</td><td>查询条件(主要是为了检查%号)</td></tr>
 * <tr><td>IDENTITY_NUM</td><td>公民身份号码</td></tr>
 * <tr><td>PHONE_NUM</td><td>固话+移动电话</td></tr>
 * <tr><td>SERIAL_NUM</td><td>序列号</td></tr>
 * </table>
 * @author YLJ 2018-3-7
 * @since 1.0
 */
public enum DataType 
{
    /**
     * 字符串，整数，精度数值，日期，字母，字母+数字，中文，固定电话，邮编，移动电话，email,IP地址,票据号,查询条件(主要是为了检查%号)
     * !!公民身份号码，电话(固话+手机)，序列号,集合
     */
    STRING,INTEGER,DECIMAL,DATE,LETTER,LETTER_NUM,CHINESE,TEL_NUM,POST_NUM,MOBILE_NUM,EMAIL,IP,BILL_NUM,WHERE,IDENTITY_NUM,PHONE_NUM,SERIAL_NUM,LIST;
}
