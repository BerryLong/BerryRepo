package com.qfedu;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class BeanInfo {
    private String id;
    @JSONField(name = "class")
    private String className;
    private String scope;
    private List<PropertyInfo> properties;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public List<PropertyInfo> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyInfo> properties) {
        this.properties = properties;
    }
}
