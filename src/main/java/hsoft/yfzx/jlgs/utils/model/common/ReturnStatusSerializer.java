package hsoft.yfzx.jlgs.utils.model.common;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 
 * 自定义对枚举类Status的序列化
 *
 * <p>主要是用于后台controller通过restController方式的ResponseBody返回时，对枚举对象的转换。如果不使用该自定义序列化，只返回枚举类型的名称<br>
 * 例如：Status类中包括code和desc两列，如果不指定自定义序列化，自动返回时，转换成json时是String类型，只显示code
 * @author goldfish 2018年3月16日
 * @see
 * @since 1.0
 */
public class ReturnStatusSerializer extends JsonSerializer<ReturnStatus>
{

    @Override
    public void serialize(ReturnStatus value, JsonGenerator jgen, SerializerProvider provider) throws IOException
    {
        jgen.writeStartObject();  
        jgen.writeStringField("code", value.getCode());  
        jgen.writeStringField("desc", value.getDesc());  
        jgen.writeEndObject();  
    }

}
