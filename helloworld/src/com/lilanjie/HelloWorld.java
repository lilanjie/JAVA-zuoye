package com.lilanjie;

//命名 类名要用大驼峰 HelloWorld
public class HelloWorld {
    public static void main(String[] args){
        Student zhanghaoyan=new Student("张昊岩",99);
        System.out.println(zhanghaoyan.getName()+"的分数是： "+zhanghaoyan.getScore());


        Student lilanjie=new Student("李澜洁",100);
        System.out.println(lilanjie.getName()+"的分数是： "+lilanjie.getScore());


        if(lilanjie.isScoreGreaterThan(zhanghaoyan)) {
            System.out.println("李澜洁比张昊岩分数高");
        }

        System.out.println(lilanjie.getFirstName());

        lilanjie.rename("盯盯");
        zhanghaoyan.print();

        Student xiaoyanyan=new Student("小岩岩",61);
        xiaoyanyan.print();

        }
    }



//要建个包，不要直接放在src下
//包名一般是公司域名倒着写  如baidu.com就会以com.baidu开头
//建个包名com.lilanjie 把代码放到包里
