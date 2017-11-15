package com.qfedu;

import redis.clients.jedis.Jedis;

public class App3 {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("10.7.190.200", 6379);
        jedis.auth("1qaz2wsx");
        System.out.println(jedis.ping());
        jedis.set("username", "admin");
        jedis.set("password", "123123");
    }
}
