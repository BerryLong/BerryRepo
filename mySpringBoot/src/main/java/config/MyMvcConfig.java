package config;

import com.qq.view.AirIndexExcelView;
import com.qq.view.RequestForLeavePdfView;
import com.qq.view.MyResumeWordView;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public BeanNameViewResolver viewResolver(){
        return new BeanNameViewResolver();
    }

//    @Bean
    public MyResumeWordView resumeView(){
        return new MyResumeWordView();
    }
    @Bean
    public RequestForLeavePdfView leavePdfView(){
        return new RequestForLeavePdfView();
    }

    @Bean
    public AirIndexExcelView excelView() {
        return new AirIndexExcelView();
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer(Connector connector) {
        TomcatEmbeddedServletContainerFactory tomcat =
                new TomcatEmbeddedServletContainerFactory() {

                    @Override
                    protected void postProcessContext(Context context) {
                        SecurityConstraint constraint = new SecurityConstraint();
                        constraint.setUserConstraint("CONFIDENTIAL");
                        SecurityCollection collection = new SecurityCollection();
                        collection.addPattern("/*");
                        constraint.addCollection(collection);
                        context.addConstraint(constraint);
                    }
                };
        tomcat.addAdditionalTomcatConnectors(connector);
        return tomcat;
    }

    @Bean
    public Connector connector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(8080);
        connector.setSecure(false);
        connector.setRedirectPort(8443);
        return connector;
    }

}
