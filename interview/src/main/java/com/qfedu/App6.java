package com.qfedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App6 {

    public static void save(Object obj, Storage storage) {
        storage.write(obj);
    }

    public static void main(String[] args) {
        Object obj = new Object();
        save(obj, new FileStorage());
        save(obj, new Storage() {
            @Override
            public void write(Object obj) {
            }
        });
        save(obj, (o) -> { });
    }
}
