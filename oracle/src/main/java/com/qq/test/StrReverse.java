package com.qq.test;

import java.time.LocalDateTime;
import java.util.Calendar;

public class StrReverse {

    public static String reverse(String oldStr){
        if(oldStr == null || oldStr.length() <= 1){
            return oldStr;
        }
        return reverse(oldStr.substring(1)) + oldStr.charAt(0);
    }

    public static void main(String[] args) {
//        String str = "qwertyuiop";
//        System.out.println(reverse(str));
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH));    // 0 - 11
        System.out.println(cal.get(Calendar.DATE));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));

        // Java 8
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.getYear());
        System.out.println(dt.getMonthValue());     // 1 - 12
        System.out.println(dt.getDayOfMonth());
        System.out.println(dt.getHour());
        System.out.println(dt.getMinute());
        System.out.println(dt.getSecond());
    }

}
