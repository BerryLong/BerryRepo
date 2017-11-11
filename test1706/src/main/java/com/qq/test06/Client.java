package com.qq.test06;

import org.jdom.JDOMException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Client {
    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException,
            ClassNotFoundException, SecurityException, NoSuchMethodException,
            IllegalArgumentException, InvocationTargetException, JDOMException, IOException {
        BeanFactory factory = new ClassPathXmlApplicationContext();
        //通过工厂直接获取
        UserService userService = (UserService) factory.getBean("userService");
        //其实User也可以从工厂中获得
        User u=(User)factory.getBean("user");
        //User u = new User();
        u.setUserName("asd");
        u.setPassword("123123");
        userService.addUser(u);//打印结果asd123123
    }

}
