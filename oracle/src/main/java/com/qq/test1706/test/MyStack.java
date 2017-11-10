package com.qq.test1706.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyStack {

    private List<String> myList = new ArrayList<>();

    public boolean push(String str){
        return myList.add(str) ? true : false;
    }

    public String move(){
        String str = myList.get(myList.size() - 1);
        myList.remove(myList.size() - 1);
        return str;
    }

    public  String pop(){
        return  myList != null ? myList.get(myList.size() - 1) : null;
    }

    public boolean check(String str){
        char[] s = str.toCharArray();
        for(int i = 0 ;i < s.length-1; i++){
            if('(' == s[i] || '{' == s[i] || '[' == s[i])  {
                push(s[i]+"");
            } else if(')' == s[i] || '}' == s[i] || ']' == s[i]) {
                move();
            }
        }
        return myList == null ? true : false;
    }
}
