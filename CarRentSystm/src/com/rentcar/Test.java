package com.rentcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("欢迎使用答答租车系统！");
        System.out.println("您是否要租车：1 是 0 否");

        Scanner input = new Scanner(System.in);
        int yesOrNot = input.nextInt();//读取键入的int 数据。
        if(yesOrNot == 1) {
            System.out.println("您可租车的类型及其价目表：");
            System.out.println("序号\t汽车名称\t租金\t容量");//\t是转义字符横向制表，还有其他转义字符，见Java笔记文件夹。
            /*
            Car car1 = new PassengerCar("奥迪A4",4,500);
            Car car2 = new PassengerCar("马自达6",4,400);
            Car car3 = new LoadAndPassenger("皮卡雪6",4, 2,450);;
            Car car4 = new PassengerCar("金龙",20,800);
            Car car5 = new LoadCar("松花江",4,400);
            Car car6 = new LoadCar("依维柯",20,1000);
            */

            Car[] rentCars = new Car[]{new PassengerCar(1, "奥迪A4", 4, 500),
                    new PassengerCar(2, "马自达6", 4, 400),
                    new LoadAndPassenger(3, "皮卡雪6", 4, 2, 450),
                    new PassengerCar(4, "金龙 ", 20, 800),
                    new LoadCar(5, "松花江", 4, 400),
                    new LoadCar(6, "依维柯", 20, 1000)};
            //建数组，存放实例对象。
            for (Car car : rentCars) {
                System.out.println(car);
            }
            //foreach循环遍历数组并打印每个实例对象的信息。
            System.out.println("请输入您要租车的数量：");
            int n = input.nextInt();
            List<String> passengerNameList = new ArrayList<>();//在list里存放车辆名字字符串
            List<String> loadNameList = new ArrayList<>();
            int sumRent = 0;
            int sumPassengers = 0;
            int sumLoad = 0;
            for (int i = 1; i <= n; i++) {
                System.out.println("请输入第" + i + "辆车的序号：");
                int number = input.nextInt();
                if (number < 1 || number > 6) {
                    System.out.println("此次输入无效，请输入合理的序号!");
                    continue;//跳出此次循环，即输入此次序号的循环，进行下一次输入。
                } else {
                    int m = number - 1;
                    //判断该序号所指向的实例对象是哪个类的,有两种写法，如下所示：
                    if (rentCars[m] instanceof PassengerCar){//rentCars[m].getClass() == PassengerCar.class) {
                        passengerNameList.add(rentCars[m].getName());
                        //注意此处调用子类属性的语法规则：
                        sumPassengers += ((PassengerCar) rentCars[m]).getPassengers();
                        sumRent += rentCars[m].getRentPrice();
                    } else if (rentCars[m].getClass() == LoadAndPassenger.class) {
                        passengerNameList.add(rentCars[m].getName());
                        loadNameList.add(rentCars[m].getName());
                        sumPassengers += ((LoadAndPassenger) rentCars[m]).getPassengers();
                        sumLoad += ((LoadAndPassenger) rentCars[m]).getLoadCap();
                        sumRent += rentCars[m].getRentPrice();
                    } else {
                        loadNameList.add(rentCars[m].getName());
                        sumLoad += ((LoadCar) rentCars[m]).getLoadCap();
                        sumRent += rentCars[m].getRentPrice();
                    }
                }
            }

                System.out.println("您要租车的天数：");
                int day = input.nextInt();
                int rent = sumRent * day;
                System.out.println("您的账单为：");
                if (passengerNameList.size() != 0) {
                    System.out.println("*****可载人的汽车有：");
                    for (String name1 : passengerNameList) {
                        System.out.print(name1 + "\t");
                    }
                    System.out.println("共载人" + sumPassengers + "人");
                }

                if (loadNameList.size() != 0) {
                    System.out.println("*****可载货的汽车有：");
                    for (String name2 : loadNameList) {
                        System.out.print(name2 + "\t");
                    }
                    System.out.println("共载货" + sumLoad + "吨");
                }

                System.out.println("*****租车价格为" + rent + "元");
                System.out.println("感谢您的使用！");

            }
        else {
            System.out.println("感谢您的使用！");
        }
    }
}
