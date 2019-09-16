package hsoft.yfzx.jlgs.utils.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 
 * 数据校验_注解类
 *
 * <p>主要用于对UI界面的输入组件的内容进行基础校验
 * <p>对于含有复杂业务逻辑的校验，本注解不做处理
 * @author YLJ 2018-3-7
 * @since 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataValidation 
{
    /**
     * 数据类型,默认：字符串
     * @return
     */
    DataType dataType() default DataType.STRING;
    
    /**
     * 是否必填项,默认：非必填
     * @return
     */
    boolean required() default false;
    
    /**
     * 长度
     * <p>字符串时，代表总长度。精度时，代表总长度，不包含小数点占的1位
     * @return
     */
    int length() default 18;
    
    /**
     * 小数位
     * @return
     */
    int decimal() default 0;
    
    /**
     * 标识，一般为UI界面中组件的id
     * @return
     */
    String tag() default "";
    
    /**
     * 描述信息
     * @return
     */
    String description() default "数据项";
    
    /**
     * 最大值,数值型时才有效
     * @return
     */
    double maximum() default 99999999999999999d;
    
    /**
     * 最小值,数值型时才有效
     * @return
     */
    double minimum() default -99999999999999999d;
}
