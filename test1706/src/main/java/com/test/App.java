package com.test;

import javax.xml.ws.Endpoint;

public class App {
    public static void main(String[] args) {
        Endpoint.publish("http://10.7.190.163:1234/hello",new HelloService());
    }
}
