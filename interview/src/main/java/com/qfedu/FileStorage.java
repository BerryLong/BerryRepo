package com.qfedu;

import java.io.Serializable;

public class FileStorage implements Storage {

    @Override
    public void write(Object obj) {
        if (obj instanceof Serializable) {

        } else {

        }
    }
}
