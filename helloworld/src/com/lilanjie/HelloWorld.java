package com.lilanjie;

//命名 类名要用大驼峰 HelloWorld
public class HelloWorld {
    public static void main(String[] args){
        Student lilanjie=new Student("lilanjie",100);
        System.out.println(lilanjie.getName()+" "+lilanjie.getScore());
        lilanjie.setScore(98);
        System.out.println(lilanjie.getName()+" "+lilanjie.getScore());

        Student liuxiaoying = new Student("liuxiaoying", 97);
        System.out.println(liuxiaoying.getName()+" "+liuxiaoying.getScore());

        if(lilanjie.isScoreGreaterThan(liuxiaoying)){
            System.out.println("李澜洁比刘晓颖分数高");
        }

    }
}

//要建个包，不要直接放在src下
//包名一般是公司域名倒着写  如baidu.com就会以com.baidu开头
//建个包名com.lilanjie 把代码放到包里
