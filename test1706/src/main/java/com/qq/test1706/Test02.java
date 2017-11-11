package com.qq.test1706;

import java.util.Arrays;

/**
 *  判断一个整数数组中能不能构成一个等差数列
 * @author Berry
 */
public class Test02 {

    public static boolean isSequence(int[] array){
        boolean flag = true;  //是否是数列
        Arrays.sort(array);
        int firstValue = array[0];  //数列首项
        int lastValue = array[array.length-1]; //数列末项

        int tolerance = (lastValue - firstValue) / (array.length - 1);  //求数列公差
        //判断数组中的值是否属于数列
        for(int i = 1; i<=array.length - 1; i++){
            int vValue = firstValue + i * tolerance;
            if(array[i] != vValue){
                flag =false;
            }
        }
        if(flag){
            System.out.println("是等差数列"+"    公差 = "+ tolerance);
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] arr = {2,10,4,6,8};
        int[] newArr = Arrays.copyOf(arr,arr.length);
        System.out.println(isSequence(newArr));
    }

}

