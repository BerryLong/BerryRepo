
package com.qq.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloService", targetNamespace = "http://test.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloService {


    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "calcSquareRoot", targetNamespace = "http://test.com/", className = "com.test.CalcSquareRoot")
    @ResponseWrapper(localName = "calcSquareRootResponse", targetNamespace = "http://test.com/", className = "com.test.CalcSquareRootResponse")
    @Action(input = "http://test.com/HelloService/calcSquareRootRequest", output = "http://test.com/HelloService/calcSquareRootResponse")
    public double calcSquareRoot(
            @WebParam(name = "arg0", targetNamespace = "")
                    double arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "translate", targetNamespace = "http://test.com/", className = "com.test.Translate")
    @ResponseWrapper(localName = "translateResponse", targetNamespace = "http://test.com/", className = "com.test.TranslateResponse")
    @Action(input = "http://test.com/HelloService/translateRequest", output = "http://test.com/HelloService/translateResponse")
    public String translate(
            @WebParam(name = "arg0", targetNamespace = "")
                    String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://test.com/", className = "com.test.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://test.com/", className = "com.test.SayHelloResponse")
    @Action(input = "http://test.com/HelloService/sayHelloRequest", output = "http://test.com/HelloService/sayHelloResponse")
    public String sayHello(
            @WebParam(name = "arg0", targetNamespace = "")
                    String arg0);

}