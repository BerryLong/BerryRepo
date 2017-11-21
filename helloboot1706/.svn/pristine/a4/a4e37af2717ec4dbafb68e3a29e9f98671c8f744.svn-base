package config;

import com.qfedu.view.AirIndexExcelView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;

import javax.sql.DataSource;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public BeanNameViewResolver viewResolver() {
        return new BeanNameViewResolver();
    }

    @Bean
    public AirIndexExcelView airExcelView() {
        return new AirIndexExcelView();
    }
}

