package com.qfedu;

public class Exam6 {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new JsonApplicationContext("ioc.json");
        Student student = context.getBean("stu1", Student.class);
        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println(student.getBirthday());
    }
}
