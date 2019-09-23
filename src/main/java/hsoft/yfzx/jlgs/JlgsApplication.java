package hsoft.yfzx.jlgs;

import hsoft.yfzx.xmpppush.XmppOperator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan({"hsoft.yfzx.jlgs.business.basic.mapper", "hsoft.yfzx.jlgs.business.basic.dao",
        "hsoft.yfzx.jlgs.business.im.mapper", "hsoft.yfzx.jlgs.business.im.dao",
        "hsoft.yfzx.jlgs.business.oa.mapper", "hsoft.yfzx.jlgs.business.oa.dao",
        "hsoft.yfzx.jlgs.business.file.mapper", "hsoft.yfzx.jlgs.business.file.dao",})
public class JlgsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JlgsApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {

        return new CommandLineRunner() {
            @Value("${custom.xmpp.host}")
            private String xmppHost;

            @Value("${custom.xmpp.domain}")
            private String xmppDomain;

            @Value("${custom.xmpp.port}")
            private int xmppPort;

            @Value("${custom.xmpp.user}")
            private String xmppUser;

            @Value("${custom.xmpp.password}")
            private String xmppPassword;

            @Value("${custom.xmpp.plugins.sessionCheckUrl}")
            private String sessionCheckUrl;

            @Value("${custom.xmpp.plugins.sessionMgUrl}")
            private String sessionMgUrl;

            @Value("${custom.xmpp.certificatePw}")
            private String certificatePw;

            @Value("${custom.xmpp.certificatePath}")
            private String certificatePath;

            @Override
            public void run(String... arg0) throws Exception
            {
                XmppOperator.setAPNS(certificatePw, certificatePath);
                XmppOperator.xmppLogin(xmppHost, xmppDomain, xmppPort, xmppUser, xmppPassword,sessionCheckUrl,sessionMgUrl);
            }
        };
    }
}
