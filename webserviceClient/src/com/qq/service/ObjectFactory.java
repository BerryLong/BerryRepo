
package com.qq.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.test package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Translate_QNAME = new QName("http://test.com/", "translate");
    private final static QName _SayHelloResponse_QNAME = new QName("http://test.com/", "sayHelloResponse");
    private final static QName _CalcSquareRootResponse_QNAME = new QName("http://test.com/", "calcSquareRootResponse");
    private final static QName _TranslateResponse_QNAME = new QName("http://test.com/", "translateResponse");
    private final static QName _SayHello_QNAME = new QName("http://test.com/", "sayHello");
    private final static QName _CalcSquareRoot_QNAME = new QName("http://test.com/", "calcSquareRoot");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.test
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CalcSquareRoot }
     * 
     */
    public CalcSquareRoot createCalcSquareRoot() {
        return new CalcSquareRoot();
    }

    /**
     * Create an instance of {@link SayHello }
     * 
     */
    public SayHello createSayHello() {
        return new SayHello();
    }

    /**
     * Create an instance of {@link TranslateResponse }
     * 
     */
    public TranslateResponse createTranslateResponse() {
        return new TranslateResponse();
    }

    /**
     * Create an instance of {@link CalcSquareRootResponse }
     * 
     */
    public CalcSquareRootResponse createCalcSquareRootResponse() {
        return new CalcSquareRootResponse();
    }

    /**
     * Create an instance of {@link SayHelloResponse }
     * 
     */
    public SayHelloResponse createSayHelloResponse() {
        return new SayHelloResponse();
    }

    /**
     * Create an instance of {@link Translate }
     * 
     */
    public Translate createTranslate() {
        return new Translate();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Translate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test.com/", name = "translate")
    public JAXBElement<Translate> createTranslate(Translate value) {
        return new JAXBElement<Translate>(_Translate_QNAME, Translate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test.com/", name = "sayHelloResponse")
    public JAXBElement<SayHelloResponse> createSayHelloResponse(SayHelloResponse value) {
        return new JAXBElement<SayHelloResponse>(_SayHelloResponse_QNAME, SayHelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalcSquareRootResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test.com/", name = "calcSquareRootResponse")
    public JAXBElement<CalcSquareRootResponse> createCalcSquareRootResponse(CalcSquareRootResponse value) {
        return new JAXBElement<CalcSquareRootResponse>(_CalcSquareRootResponse_QNAME, CalcSquareRootResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TranslateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test.com/", name = "translateResponse")
    public JAXBElement<TranslateResponse> createTranslateResponse(TranslateResponse value) {
        return new JAXBElement<TranslateResponse>(_TranslateResponse_QNAME, TranslateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test.com/", name = "sayHello")
    public JAXBElement<SayHello> createSayHello(SayHello value) {
        return new JAXBElement<SayHello>(_SayHello_QNAME, SayHello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalcSquareRoot }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test.com/", name = "calcSquareRoot")
    public JAXBElement<CalcSquareRoot> createCalcSquareRoot(CalcSquareRoot value) {
        return new JAXBElement<CalcSquareRoot>(_CalcSquareRoot_QNAME, CalcSquareRoot.class, null, value);
    }

}
