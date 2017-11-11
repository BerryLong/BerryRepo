package com.qq.test1706;

import java.util.Comparator;

/**
 *  用一次循环找出数组中的第二大元素
 * @author Berry
 */
public class Test01 {


    public static <T extends Comparable<T>> T secondaryMax(T[] array) {
        T maxValue = array[0];
        T secdValue = array[1];
        if(maxValue.compareTo(secdValue) < 0){
                T temp = maxValue;
                maxValue = secdValue;
                secdValue = temp;
        }
            for(int i = 2; i <= array.length - 1; i++){
                if(array[i].compareTo(maxValue) < 0 && array[i].compareTo(secdValue)  > 0){
                    secdValue = array[i];
                } else if(array[i].compareTo(maxValue) > 0){
                    maxValue = array[i];
                }
            }
        return (T) secdValue;
    }

    public static <T> T secondaryMax(T[] array, Comparator<T> comp) {
        T maxValue = array[0];
        T secdValue = array[1];
        if(comp.compare(secdValue,maxValue)  > 0) {
                T temp = maxValue;
                maxValue = secdValue;
                secdValue = temp;
        }
            for(int i = 2; i <= array.length - 1; i++) {
                if (comp.compare(array[i], maxValue) > 0 && comp.compare(array[i], secdValue) <0) {
                    secdValue = array[i];
                } else if (comp.compare(array[i], maxValue) < 0) {
                    maxValue = array[i];
                }
            }
            return (T) secdValue;
    }

    public static void main(String[] args) {
        //测试可以比较的类型
        Integer[] arr = {15,64,48,89,78};
        System.out.println(secondaryMax(arr));
        //自定义比较方法测试
        Comparator<Student> comp = new Comparator<Student>() {
            @Override
            public int compare(Student stu1, Student stu2) {
                if(stu1.getScore().compareTo(stu2.getScore()) > 0) {
                    return 1;
                } else if(stu1.getName().compareTo(stu2.getName()) > 0) {
                    return 1;
                } else if(stu1.getId() - stu2.getId() > 0) {
                    return 1;
                } else {
                    return  0;
                }
            }
        };
        Student stu1 = new Student(1001,"B","120");
        Student stu2 = new Student(1001,"B","140");
        Student[] stu = {stu1,stu2};
        System.out.println(secondaryMax(stu,comp));
    }
}
