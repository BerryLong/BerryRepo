package com.qfedu.ann.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

// 这个类就相当于我们之前写的web.xml文件
// 这个类中方法会在Web服务器启动时自动配回调 此处相当于完成了前端控制器、监听器和过滤器的配置
public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //  Spring IoC的配置在哪些类中
    @Override
    protected Class<?>[] getRootConfigClasses() {

        return new Class[] { AppConfig.class };
    }


    // Spring MVC的配置在哪些类中
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { MvcConfig.class };
    }

    // 配置前端控制器的映射
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    // 配置过滤器
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] {
                new CharacterEncodingFilter("utf-8", true)
        };
    }
}
