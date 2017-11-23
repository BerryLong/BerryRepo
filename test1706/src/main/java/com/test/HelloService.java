package com.test;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

@WebService
public class HelloService {

    private static Map<String,String> map =new HashMap<>();
    static {
        map.put("苹果", "apple");
        map.put("傻逼", "SB");
        map.put("李滔","SB");
    }

    @WebMethod
    public  String sayHello(String name){
        return "Hello, "+name;
    }

    @WebMethod
    public double calcSquareRoot(double temp){
        return Math.sqrt(temp);
    }

    @WebMethod
    public String translate(String temp){
        return map.containsKey(temp) ? map.get(temp) : "不能翻译";
    }
}
