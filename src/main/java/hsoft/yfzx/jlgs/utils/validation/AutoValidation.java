package hsoft.yfzx.jlgs.utils.validation;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 自动校验工具类
 *
 * <p>
 * detailed comment
 * @author YLj 2018年3月7日
 * @since 1.0
 */
public class AutoValidation
{
    /**
     * 被校验的类的实例
     */
    private Object object;

    /**
     * 校验失败原因
     */
    private List<FailCause> failCauses;

    public AutoValidation(Object obj)
    {
        this.object = obj;
        this.failCauses = new ArrayList<FailCause>();
    }

    /**
     * 校验指定的成员变量
     * @param fieldName
     * @return
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public boolean singleValidation(String fieldName)
    {
        // 获得指定的Field
        Field field;
        try
        {
            field = this.object.getClass().getDeclaredField(fieldName);
        }
        catch (Exception e)
        {
            this.failCauses.add(new FailCause("", "", "无法获取需要校验的数据项列表"));
            return false;
        }
        return validation(new Field[]
        { field });
    }

    /**
     * 校验全部组件
     * @return
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public boolean validation()
    {
        return validation(null);
    }

    /**
     * 数据校验
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public boolean validation(Field[] fields)
    {
        boolean result = true;

        String fieldName = "";
        String firstLetter = "";
        String getMethodName = "";

        // 被校验的值
        Object value = "";
        String tmpValue = "";
        double tmpDouble = 0.0;
        int tmpInteger = 0;
        // 读取注解
        if (fields == null)
        {
            // 默认遍历全部成员变量
            fields = this.object.getClass().getDeclaredFields();
        }

        // 注解信息项
        // 标识
        String tag = "";

        // 数据类型
        DataType dataType = null;

        // 是否必填
        boolean isRequired = false;

        // 总长度
        int length = 0;
        // 小数位长度
        int decimal = 0;
        // 描述
        String description = "";
        // 最大值
        double maximum = 0.0;
        // 最小值
        double minimum = 0.0;

        boolean hasAnnotation = false;
        // 遍历
        for (int idx = 0; idx < fields.length; idx++)
        {
            hasAnnotation = false;
            // 取得数据对象
            Field field = fields[idx];
            /*
             * 判断是否有指定注解类型的注解
             */
            hasAnnotation = field.isAnnotationPresent(DataValidation.class);

            if (hasAnnotation)
            {
                // 包含指定的注解
                // 获得注解对象
                DataValidation annotation = field.getAnnotation(DataValidation.class);
                // 读取注解信息
                // 数据标识
                tag = annotation.tag();
                if ("".equals(tag))
                {
                    // 如果未指定tag，则tag默认等于该成员变量的名称
                    tag = field.getName();
                }
                // 数据类型
                dataType = annotation.dataType();
                // 是否必填
                isRequired = annotation.required();
                // 总长度
                length = annotation.length();
                // 小数位长度
                decimal = annotation.decimal();
                // 描述
                description = annotation.description();
                // 最大值
                maximum = annotation.maximum();
                // 最小值
                minimum = annotation.minimum();

                // 成员变量名称
                fieldName = field.getName();
                // 取首字母，并转换成大写
                firstLetter = fieldName.substring(0, 1).toUpperCase();
                // 拼get方法名称
                getMethodName = "get" + firstLetter + fieldName.substring(1);

                // 获得getText()方法对象
                Method getMethod;
                try
                {
                    getMethod = this.object.getClass().getMethod(getMethodName, new Class[] {});
                }
                catch (Exception e)
                {
                    this.failCauses.add(new FailCause(tag, description, "无法获取需要校验的数据"));
                    continue;
                }

                try
                {
                    value = getMethod.invoke(this.object, new Object[] {});
                }
                catch (Exception e)
                {
                    this.failCauses.add(new FailCause(tag, description, "无法获取需要校验的数据"));
                    continue;
                }
                // 开始校验
                if (dataType == DataType.LIST)
                {
                    // 数据是集合类型，则只较验是否为null和集合长度
                    if (isRequired)
                    {
                        //设置为必填项,需要校验null和长度
                        if (value == null)
                        {
                            this.failCauses.add(new FailCause(tag, description, "数据为必填项"));
                            continue;
                        }
                        // 不为空，则校验集合长度
                        if (value instanceof List)
                        {
                            List<?> listObj = (List<?>) value;
                            if (listObj.size() < length)
                            {
                                // 长度不符
                                this.failCauses.add(new FailCause(tag, description, "集合中数据的个数少于" + length));
                                continue;
                            }
                        }
                    }
                    // 返回下一轮循环
                    continue;
                }
                if(value == null) 
                {
                    tmpValue = "";
                }
                else if(value instanceof BigDecimal) 
                {
                     tmpValue = ((BigDecimal)value).toPlainString();
                }
                else
                {
                    tmpValue = String.valueOf(value);
                }
                
                
                if (CheckUtil.isEmpty(tmpValue))
                {
                    // 字符串为空,校验是否必填
                    if (isRequired)
                    {
                        this.failCauses.add(new FailCause(tag, description, "数据为必填项"));
                        // 校验下一个组件
                        continue;
                    }
                }
                else
                {
                    // 不为空，再进行其它校验
                    switch (dataType)
                    {
                        case INTEGER:
                            // 整数
                            if (!CheckUtil.isNum(tmpValue))
                            {
                                this.failCauses.add(new FailCause(tag, description, "数据必须是整数"));
                            }
                            else
                            {
                                tmpInteger = Integer.parseInt(tmpValue);
                                // 最大值和最小值
                                if (tmpInteger > maximum)
                                {
                                    // [{0}]应小于{1}，请重新填写!
                                    this.failCauses.add(new FailCause(tag, description, "数据超过限定最大值" + maximum));
                                }
                                else if (tmpInteger < minimum)
                                {
                                    // [{0}]应小于{1}，请重新填写!
                                    this.failCauses.add(new FailCause(tag, description, "数据低于限定最小值" + minimum));
                                }
                            }
                            break;
                        case DECIMAL:
                            // 精度数值
                            // 首先校验，是否是有效的精度数值
                            if (!CheckUtil.isDouble(tmpValue))
                            {
                                // 数据格式不正确
                                this.failCauses.add(new FailCause(tag, description, "数据格式不正确"));
                            }
                            else
                            {
                                // 格式正确，校验整数位的长度，小数位的长度,以及最大值和最小值
                                tmpDouble = Double.parseDouble(tmpValue);

                                // 最大值和最小值
                                if (tmpDouble > maximum)
                                {
                                    // [{0}]应小于{1}，请重新填写!
                                    this.failCauses.add(new FailCause(tag, description, "数据超过限定最大值" + BigDecimal.valueOf(maximum).toPlainString()));
                                }
                                else if (tmpDouble < minimum)
                                {
                                    // [{0}]应小于{1}，请重新填写!
                                    this.failCauses.add(new FailCause(tag, description, "数据低于限定最小值" + BigDecimal.valueOf(minimum).toPlainString()));
                                }
                                else if (tmpValue.length() > length)
                                {
                                    // 校验整数位长度
                                    // [{0}]长度不能超过{1}位，请重新填写!
                                    this.failCauses.add(new FailCause(tag, description, "数据长度超过" + length));
                                }
                                else
                                {
                                    // 校验小数长度
                                    if (tmpValue.indexOf(".") != -1)
                                    {
                                        // 截取小数部分字符串
                                        String decimalStr = tmpValue.substring(tmpValue.indexOf(".") + 1);
                                        if (decimalStr.length() > decimal)
                                        {
                                            // 小数部分的长度超过指定长度
                                            // = [{0}]应保留{1}位小数，请重新填写!
                                            this.failCauses.add(new FailCause(tag, description, "数据小数位的长度超过" + decimal));
                                        }
                                    }
                                }
                            }
                            break;
                        case DATE:
                            // 日期
                            if (!CheckUtil.checkDate(tmpValue, "YYYYMMDD"))
                            {
                                // 提示格式不正确
                                this.failCauses.add(new FailCause(tag, description, "数据格式不符合YYYYMMDD格式"));
                            }
                            break;
                        case LETTER:
                            // 字母
                            if (!CheckUtil.isLetter(tmpValue))
                            {
                                // [{0}]必须是英文字母组成，请重新填写!
                                this.failCauses.add(new FailCause(tag, description, "数据格式必须是英文字母组成"));
                            }
                            break;
                        case LETTER_NUM:
                            // 字母+数字
                            if (!CheckUtil.isLetterNum(tmpValue))
                            {
                                // error0028 = [{0}]必须是英文字母或阿拉伯数字组成，请重新填写!
                                this.failCauses.add(new FailCause(tag, description, "数据格式必须是英文字母或阿拉伯数字组成"));
                            }
                            break;
                        case CHINESE:
                            // 中文
                            if (!CheckUtil.isChinese(tmpValue))
                            {
                                // error0029 = [{0}]必须是中文组成，请重新填写!
                                this.failCauses.add(new FailCause(tag, description, "数据格式必须是中文组成"));
                            }
                            break;
                        case TEL_NUM:
                            // 固定电话
                            if (!CheckUtil.checkTelNum(tmpValue))
                            {
                                // 提示格式不正确
                                this.failCauses.add(new FailCause(tag, description, "数据格式不正确"));
                            }
                            break;
                        case PHONE_NUM:
                            // 固定电话或手机
                            if (!CheckUtil.checkPhoneNum(tmpValue))
                            {
                                // 提示格式不正确
                                this.failCauses.add(new FailCause(tag, description, "数据格式不正确"));
                            }
                            break;
                        case SERIAL_NUM:
                            // 编码
                            if (!CheckUtil.limitNum(tmpValue))
                            {
                                // 提示必须由数字组成
                                this.failCauses.add(new FailCause(tag, description, "数据格式必须由数字组成"));
                            }
                            break;
                        case POST_NUM:
                            // 邮编
                            if (!CheckUtil.checkPostNum(tmpValue))
                            {
                                // 提示格式不正确
                                this.failCauses.add(new FailCause(tag, description, "数据格式不正确"));
                            }
                            break;
                        case MOBILE_NUM:
                            // 移动电话
                            if (!CheckUtil.checkMobileNum(tmpValue))
                            {
                                // 提示格式不正确
                                this.failCauses.add(new FailCause(tag, description, "数据格式不正确"));
                            }
                            break;
                        case EMAIL:
                            // email
                            if (!CheckUtil.checkEmail(tmpValue))
                            {
                                // 提示格式不正确
                                this.failCauses.add(new FailCause(tag, description, "数据格式不正确"));
                            }
                            break;
                        case IP:
                            if (!CheckUtil.checkIP(tmpValue))
                            {
                                // 提示格式不正确
                                this.failCauses.add(new FailCause(tag, description, "数据格式不正确"));
                            }
                            break;
                        case BILL_NUM:
                            // 票据号格式(字母数字和减号)
                            if (!CheckUtil.isBillNum(tmpValue))
                            {
                                // error0030 = [{0}]必须是英文字母、阿拉伯数字或减号组成，请重新填写!
                                this.failCauses.add(new FailCause(tag, description, "数据格式必须是英文字母、阿拉伯数字或减号组成"));
                            }
                            break;
                        case IDENTITY_NUM:
                            // 公民身份证格式
                            if (!CheckUtil.checkCivilIdNum(tmpValue))
                            {
                                // 提示格式不正确
                                this.failCauses.add(new FailCause(tag, description, "数据格式不正确"));
                            }
                            break;
                        case WHERE:
                            // 此处代码，不需要break!!，因为校验完WHERE后，还要进行正常的字符串校验，即调用default下面的代码
                            if (!CheckUtil.isWhere(tmpValue))
                            {
                                // [{0}]包含了非法字符，请重新填写!
                                this.failCauses.add(new FailCause(tag, description, "数据包含非法字符"));
                                break;
                            }
                            // 继续执行default下面的代码
                        default:
                            // 默认，全部按字符串类型进行校验
                            // 校验特殊字符
                            if (CheckUtil.hasSpecialChar(tmpValue))
                            {
                                // [{0}]包含了非法字符，请重新填写!
                                this.failCauses.add(new FailCause(tag, description, "数据包含非法字符"));
                            }
                            else if (tmpValue.length() > length)
                            {
                                // 校验最大长度
                                // [{0}]长度不能超过{1}位，请重新填写!
                                this.failCauses.add(new FailCause(tag, description, "数据长度超过" + length));
                            }
                            else if (tmpValue.length() < minimum)
                            {
                                // 校验最小长度
                                // [{0}]应大于{1}，请重新填写!
                                this.failCauses.add(new FailCause(tag, description, "数据长度小于" + length));
                            }

                    }
                }
            }
        }

        if (this.failCauses.size() > 0)
        {
            result = false;
        }
        return result;
    }

    public List<FailCause> getFailCauses()
    {
        return failCauses;
    }
}
