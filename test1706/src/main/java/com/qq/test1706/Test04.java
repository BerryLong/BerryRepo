package com.qq.test1706;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

/**
 *  设计一个类似于ArrayList的容器，实现添加, 删除, 查询, 删除全部, 插入功能
 * @author Berry
 * @param <T>  泛型参数
 */
public class Test04<T> {
    Object[] arrays = new Object[0];
    /**
     * 添加元素
     * @return 添加成功返回true,否则返回false
     */
    public boolean add(Object obj){
        boolean flag =false;
        Object[] newArr = new Object[arrays.length+1];
        for (int i = 0; i<arrays.length;i++){
            newArr[i] = arrays[i];
        }
        newArr[arrays.length] = obj;
        arrays = newArr;
        flag = true;

        return  flag;
    }

    /**
     * 插入元素
     * index 插入元素下标
     *  obj 插入的元素值
     * @return 插入成功返回true,否则返回false
     */
    public boolean insert(int index,Object obj){
        Object[] newArr = new Object[arrays.length + 1];
        if(arrays.length!=0&&index<arrays.length){
            for(int i = 0; i<index;i++){
                newArr[i] = arrays[i];
            }
            newArr[index] = obj;
            for(int i = index;i<arrays.length;i++){
                newArr[i+1]=arrays[i];
            }
        } else{
            arrays[0] = obj;
        }
        arrays = newArr;
        return  false;
    }

    /**
     * 删除元素
     * index 元素下标
     * @return 删除成功返回true,否则返回false
     */
    public boolean delete(int index){
        boolean flag = false;
        Object[] newArr = new Object[arrays.length - 1];
        int j = 0;
        if(index < arrays.length){
            for(int i = 0; i< arrays.length;i++){
                if(i == index){
                } else{
                    newArr[j] = arrays[i];
                    j++;
                }
            }
            arrays = newArr;
            flag = true;
        }

        return  flag;
    }

    /**
     * 删除全部元素
     * @return 删除成功返回true,否则返回false
     */
    public boolean removeAll(){
        boolean flag=false;
        Object[] newArr = new Object[0];
        arrays = newArr;
        if(arrays.length==0){
            flag=true;
        }
        return  flag;
    }

    /**
     * 获得对应下标的元素
     * @param index
     * @return
     */
    public T get(int index){
        T temp = null;
        if(index < arrays.length){
            temp = (T) arrays[index];
        }
        return temp;
    }

    /**
     * 查看集合数量
     * @return 元素个数
     */
    public int size(){
        return arrays.length;
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        //创建list 添加五个元素
        Test04<String> list = new Test04<>();
        list.add("Sb1");
        list.add("Sb2");
        list.add("Sb3");
        list.add("Sb4");
        list.add("Sb5");
        System.out.println("原始长度 = " + list.size());   //长度为5
        //获取下标为3的元素
        System.out.println("下标为3的元素是: " + list.get(3));   //值为Sb4
        //删除下标为3的元素
        list.delete(3);
        //删除后查询下标为3的元素
        System.out.println("删除下标为3 的元素后当前元素是: " + list.get(3));  // 值为Sb5
        System.out.println("删除后的长度 = "+list.size());  //长度为4
        //在下标为3的位置插入删除的元素“”Sb4
        list.insert(3,"Sb4");
        //遍历插入后的所有元素
        System.out.println("在下标为3的位置插入'Sb4'后所有元素");
        for (int i=0;i<list.size();i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println("删除所有元素");
        //删除所有元素
        list.removeAll();
        System.out.println("删除所有元素后长度 = "  + list.size());//长度为0
    }
}
