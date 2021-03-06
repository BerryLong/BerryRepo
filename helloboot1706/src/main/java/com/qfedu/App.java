package com.qfedu;

import config.MyMvcConfig;
import config.MyWebSocketConfig;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Import({MyMvcConfig.class, MyWebSocketConfig.class})
@SpringBootApplication
@RestController
public class App {

    @GetMapping(value = "/", produces = "text/plain; charset=utf-8")
    public String home() {
        return "hello, world! 你好世界!";
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer(Connector connector) {  // 配置所有请求都要走安全连接
        TomcatEmbeddedServletContainerFactory tomcat =
                new TomcatEmbeddedServletContainerFactory() {

                    @Override
                    protected void postProcessContext(Context context) {
                        // 配置安全约束
                        SecurityConstraint constraint = new SecurityConstraint();
                        constraint.setUserConstraint("CONFIDENTIAL");
                        // 指定哪些URL要走HTTPS
                        SecurityCollection collection = new SecurityCollection();
                        collection.addPattern("/*");
                        constraint.addCollection(collection);
                        // 修改上下文环境加入安全约束
                        context.addConstraint(constraint);
                        // 原来这段内容是写到web.xml文件中的
                    }
                };
        tomcat.addAdditionalTomcatConnectors(connector);
        return tomcat;
    }

    @Bean
    public Connector connector() {  // 配置从8080端口连接的连接器
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(8080);
        connector.setSecure(false);
        connector.setRedirectPort(8443);
        return connector;
        // 原来这段内容是配置到server.xml文件中的
        // 在Spring Boot项目中由于使用内嵌式的Tomcat没有配置文件可以改
        // 所以通过Tomcat提供的API以代码的方式修改了上下文和服务器的配置
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
