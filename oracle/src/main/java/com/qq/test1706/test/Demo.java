package com.qq.test1706.test;

/**
 * @author Berry
 */
public class Demo {

    public static<T extends Comparable> void merge(T[] a,T[] b,T[] c){
        int aIndex = 0,bIndex = 0,cIndex=0;
        while (aIndex<a.length && bIndex < b.length) {
            if(a[aIndex].compareTo(b[bIndex]) <= 0 ){
                c[cIndex++] = a[aIndex++];
            } else{
                c[cIndex++] = b[bIndex++];
            }
        }
        while (aIndex < a.length) {
            c[cIndex++] = a[aIndex++];
        }
        while(bIndex < b.length){
            c[cIndex++] = b[bIndex++];
        }
    }

    public static void main(String[] args) {

        Integer[] a = {12,32,43,54,65,76,98,123};
        Integer[] b = {32,43,54,67,68,76,87,90,99,233};
        Integer[] c = new Integer[a.length+b.length];
        merge(a,b,c);
        for (int i : c){
            System.out.print(i + " ");
        }
        /*String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());*/
    }

}
