package com.qfedu;

public interface ApplicationContext {

    <T> T getBean(String id, Class<T>type);

    Object getBean(String id);
}
