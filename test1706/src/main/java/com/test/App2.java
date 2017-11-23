package com.test;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class App2 {

    public static void main(String[] args) throws Exception {
        JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
        Client client = factory.createClient("http://10.7.190.163:1234/hello?wsdl");
        Object[] objects = client.invoke("sayHello","李滔");
        System.out.println((String) objects[0]);
        Object[] objects1 = client.invoke("calcSquareRoot",4);
        System.out.println((double)objects1[0]);
        Object[] objects2 = client.invoke("translate","李滔");
        System.out.println((String)objects2[0]);
    }
}
