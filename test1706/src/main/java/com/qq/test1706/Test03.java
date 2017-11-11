package com.qq.test1706;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * 添加一个序列，并持久化（此程序使用Redis进行持久化）
 */
public class Test03 {

    public static void mySequence(int start,int end,int step) throws InterruptedException {
        List<Integer> myList = new ArrayList<>();
        Jedis jedis = new Jedis("10.7.190.163",6379);

        String str =jedis.get("myList");
        if(str != null){
            str = str.substring(1,str.length()-1);
            String[] strs = str.split(",");
            start = Integer.parseInt(strs[strs.length-1].trim()) + step;
            iteratorValue(start, end, step, myList, jedis);
        }else{
            iteratorValue(start, end, step, myList, jedis);
        }
    }

    private static void iteratorValue(int start, int end, int step, List<Integer> myList, Jedis jedis) throws InterruptedException {
        for(int i = start;i<=end; i +=step){
            myList.add(i);
            jedis.set("myList",myList.toString());
            System.out.println(i);
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        mySequence(100,400,2);
    }

}
