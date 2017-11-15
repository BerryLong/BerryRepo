package com.qfedu;

import redis.clients.jedis.Jedis;

public class App4 {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("10.7.190.200", 6379);
        jedis.auth("1qaz2wsx");
        System.out.println(jedis.get("username"));
        System.out.println(jedis.get("fucker"));
    }
}
