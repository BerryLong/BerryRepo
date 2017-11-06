package com.qfedu.ann.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.qfedu.ann.domain.User;
import org.hibernate.SessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

// Spring IoC的配置
@Configuration
//  <context:component-scan>
//      <context:exclude-filter>
//表示哪些类要纳入ioc容器，哪些需要排除
@ComponentScan(
        basePackages = "com.qfedu.ann",
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = { Controller.class, ControllerAdvice.class,  Configuration.class }
        )
)
// <aop:aspectj-autoproxy>
//配置AOP切面
@EnableAspectJAutoProxy
// <tx:annotation-driven>
@EnableTransactionManagement
// <bean class="PropertyPlaceholderConfigurer">
@PropertySource("classpath:application.properties")
// <bean class="MapperScannerConfigurer">
@MapperScan("com.qfedu.ann.mapper")
// @Import(AppConfig2.class)
// @ImportResource("classpath:appConfig3.xml")
public class AppConfig {
        // SpEL - Spring 表达式语言
        @Value("${jdbc.url}")
        private String url;
        @Value("${jdbc.username}")
        private String username;
        @Value("${jdbc.password}")
        private String password;

        @Bean
        public DataSource dataSource() {
                DruidDataSource dataSource = new DruidDataSource();
                dataSource.setUrl(url);
                dataSource.setUsername(username);
                dataSource.setPassword(password);
                dataSource.setInitialSize(20);
                dataSource.setMinIdle(20);
                dataSource.setMaxActive(50);
                dataSource.setMaxWait(10000);
                return dataSource;
        }

        @Bean
        public LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource) {
                LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
                sessionFactoryBean.setDataSource(dataSource);
                sessionFactoryBean.setPackagesToScan("com.qfedu.ann.domain");
                Properties props = new Properties();
                props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
                props.setProperty("hibernate.show_sql", "true");
                props.setProperty("hibernate.format_sql", "true");
                sessionFactoryBean.setHibernateProperties(props);
                return sessionFactoryBean;
        }

        @Bean
        public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
                SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
                sqlSessionFactoryBean.setDataSource(dataSource);
                sqlSessionFactoryBean.setTypeAliases(new Class[]{User.class});
                PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
                Resource[] resources = resolver.getResources("classpath:com/qfedu/ann/mapper/*.xml");
                sqlSessionFactoryBean.setMapperLocations(resources);
                return sqlSessionFactoryBean;
        }

        @Bean
        public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
                return new HibernateTransactionManager(sessionFactory);
        }

}
