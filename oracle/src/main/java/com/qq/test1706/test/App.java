package com.qq.test1706.test;

import redis.clients.jedis.Jedis;

public class App {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("10.7.190.163",6379);
        System.out.println(jedis.ping());
        jedis.set("name","LiTao");
        jedis.set("xname","sbLea");
    }

}
