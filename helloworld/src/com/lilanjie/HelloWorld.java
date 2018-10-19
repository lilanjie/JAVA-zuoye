package com.lilanjie;


import javax.naming.Name;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//命名 类名要用大驼峰 HelloWorld
public class HelloWorld {
    public static void main(String[] args) {
        Student zhanghaoyan = new Student("张昊岩", 99);
        //System.out.println(zhanghaoyan.getName()+"的分数是： "+zhanghaoyan.getScore());


        Student lilanjie = new Student("李澜洁", 100);
        //System.out.println(lilanjie.getName()+"的分数是： "+lilanjie.getScore());


        //if(lilanjie.isScoreGreaterThan(zhanghaoyan)) {
        //System.out.println("李澜洁比张昊岩分数高");
        //}

        //System.out.println(lilanjie.getFirstName());

        // lilanjie.rename("盯盯");
        //zhanghaoyan.print();

        Student xiaoyanyan = new Student("小岩岩", 61);
        //xiaoyanyan.print();

        Student kenan = new Student("柯南", 92);
        Student maolilan = new Student("毛利兰", 90);
        Student huiyuanai = new Student("灰原哀", 91);
        Student gongtengxinyi = new Student("工藤新一", 88);
        Student maolixiaowulang = new Student("毛利小五郎", 87);
        Student lingmuyuanzi = new Student("铃木园子", 70);
        Student fubupingci = new Student("服部平次", 90);
        Student huge = new Student("胡歌", 98);
        Student dilireba = new Student("迪丽热巴", 97);


        //List<Student> list = new ArrayList<>();
        //list.add(lilanjie);
        //list.add(zhanghaoyan);
        //list.add(xiaoyanyan);
        //list.add(kenan);
        //list.add(maolilan);
        //list.add(huiyuanai);
        //list.add(gongtengxinyi);
        //list.add(maolixiaowulang);
        //list.add(fubupingci);
        //尝试一下使用 for(Student student:list){}遍历
        //int i;
        //for(i=0;i<list.size();i++){
        //Student s = list.get(i);
        //s.print();
        //}
        // for(Student student:list){
        //    student.print();
        //}

        //Map<String,Student>map=new HashMap<>();
        //map.put("李澜洁" ,lilanjie);
        //map.put("张昊岩",zhanghaoyan);
        //map.put("胡歌",huge);
        //map.put("迪丽热巴",dilireba);

        //map.get("胡歌").print();

    //StudentList list=new StudentList();
        // list.add(0,lilanjie);
        // list.add(1,zhanghaoyan);
         //list.add(2,xiaoyanyan);
         //list.add(3,kenan);
        // list.add(4,dilireba);
        // list.add(2,huge);
        //list.remove(3);

        // list.add(9,huge);
        // Student n=list.getStudent(2);
        // n.print();
        StudentLinkedList linkedList = new StudentLinkedList();
        ((StudentLinkedList) linkedList).add(0,lilanjie);
         ((StudentLinkedList) linkedList).add(1,zhanghaoyan);
        ((StudentLinkedList) linkedList).add(2,xiaoyanyan);
        ((StudentLinkedList) linkedList).add(3,kenan);
         ((StudentLinkedList) linkedList).add(4,dilireba);
         ((StudentLinkedList) linkedList).add(5,huge);







    }
}



//要建个包，不要直接放在src下
//包名一般是公司域名倒着写  如baidu.com就会以com.baidu开头
//建个包名com.lilanjie 把代码放到包里
