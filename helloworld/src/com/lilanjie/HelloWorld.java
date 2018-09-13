package com.lilanjie;


import java.util.ArrayList;
import java.util.List;

//命名 类名要用大驼峰 HelloWorld
public class HelloWorld {
    public static void main(String[] args){
        Student zhanghaoyan=new Student("张昊岩",99);
        //System.out.println(zhanghaoyan.getName()+"的分数是： "+zhanghaoyan.getScore());


        Student lilanjie=new Student("李澜洁",100);
        //System.out.println(lilanjie.getName()+"的分数是： "+lilanjie.getScore());


        if(lilanjie.isScoreGreaterThan(zhanghaoyan)) {
           //System.out.println("李澜洁比张昊岩分数高");
        }

        //System.out.println(lilanjie.getFirstName());

       // lilanjie.rename("盯盯");
        //zhanghaoyan.print();

        Student xiaoyanyan=new Student("小岩岩",61);
        //xiaoyanyan.print();

        Student kenan=new Student("柯南",92);
        Student maolilan=new Student("毛利兰",90);
        Student huiyuanai=new Student("灰原哀",91);
        Student gongtengxinyi=new Student("工藤新一",88);
        Student maolixiaowulang=new Student("毛利小五郎",87);
        Student lingmuyuanzi=new Student("铃木园子",70);
        Student fubupingci=new Student("服部平次",90);


        List<Student> list = new ArrayList<>();
        list.add(lilanjie);
        list.add(zhanghaoyan);
        list.add(xiaoyanyan);
        list.add(kenan);
        list.add(maolilan);
        list.add(huiyuanai);
        list.add(gongtengxinyi);
        list.add(maolixiaowulang);
        list.add(lingmuyuanzi);
        list.add(fubupingci);
        int i;
      for(i=0;i<list.size();i++){
            Student s = list.get(i);
            s.print();
        }




        }
    }



//要建个包，不要直接放在src下
//包名一般是公司域名倒着写  如baidu.com就会以com.baidu开头
//建个包名com.lilanjie 把代码放到包里
