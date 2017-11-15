package com.qfedu;

import com.alibaba.fastjson.JSON;
import org.apache.commons.beanutils.BeanUtils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonApplicationContext implements ApplicationContext {
    private Map<String, Object> map = new HashMap<>();
    private String configFilename;

    public JsonApplicationContext(String configFilename) {
        this.configFilename = configFilename;
        _init();
    }

    @Override
    public <T> T getBean(String id, Class<T> type) {
        return (T) map.get(id);
    }

    @Override
    public Object getBean(String id) {
        return map.get(id);
    }

    private void _init() {
        try {
            InputStream in = this.getClass().getClassLoader().getResourceAsStream(configFilename);
            byte[] buffer = new byte[in.available()];
            in.read(buffer);
            String jsonStr = new String(buffer, "utf-8");
            List<BeanInfo> allInfo = JSON.parseArray(jsonStr, BeanInfo.class);
            for (BeanInfo beanInfo : allInfo) {
                Class clazz = Class.forName(beanInfo.getClassName());
                Object obj = clazz.newInstance();
                if (beanInfo.getProperties() != null) {
                    for (PropertyInfo propInfo : beanInfo.getProperties()) {
                        if (propInfo.getPropertyValue() != null) {
                            BeanUtils.setProperty(obj, propInfo.getPropertyName(), propInfo.getPropertyValue());
                        } else if (propInfo.getPropertyRef() != null) {
                            Object value = map.get(propInfo.getPropertyRef());
                            BeanUtils.setProperty(obj, propInfo.getPropertyName(), value);
                        }
                    }
                }
                map.put(beanInfo.getId(), obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
