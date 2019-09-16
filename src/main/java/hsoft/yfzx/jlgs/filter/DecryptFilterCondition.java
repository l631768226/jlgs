package hsoft.yfzx.jlgs.filter;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 
 * 用于从配置文件中获取信息
 *
 * <p>配置文件中配置"custom.encrypt"参数，用来表示是否需要采用加解密模式。该参数决定是否将加解密的过滤器挂载到spring容器中
 * @author YLJ 2018年5月16日
 * @since 1.0
 */
public class DecryptFilterCondition implements Condition
{

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata)
    {
        String encrypt = context.getEnvironment().getProperty("custom.encrypt");
        System.out.println("@@@@@@@@@@@@@@@@@@");
        System.out.println("@@@@ 加解密模式 @@@@");
        if(encrypt.equalsIgnoreCase("true")) 
        {
            System.out.println("@@@@    开启   @@@@");
        }
        else
        {
            System.out.println("@@@@   未开启  @@@@");
        }
        System.out.println("@@@@@@@@@@@@@@@@@@");
        return ("true").equalsIgnoreCase(encrypt);
    }

}
