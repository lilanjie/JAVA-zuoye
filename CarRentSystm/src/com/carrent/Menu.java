package com.carrent;

//import jdk.nashorn.internal.parser.Scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Car car = new Car();
        System.out.print("欢迎使用答答租车系统" + "\n" + "您是否要租车：1 是  0 否" + "\n");
        Scanner input = new Scanner(System.in);
        System.out.println("请输入：");
        int yesOrNot = input.nextInt();
        if (yesOrNot == 1) {
            car.showCar();
            /*
            for (int i = 1; i < 7 ; i ++){
                Car.chooseCar(i);
            }
            */
            System.out.println("请输入您要租车的数量：");
            int num = input.nextInt();
            int pNum = 0;
            int lNum = 0;
            int rent = 0;
            List<String> pNamelist = new ArrayList<>();
            List<String> lNamelist = new ArrayList<>();
            for (int i = 1; i <= num; i++) {
                System.out.println("请输入第" + i + "辆车的序号：");
                int n = input.nextInt();
                pNum = pNum + car.chooseCar_pNum(n);
                lNum = lNum + car.chooseCar_lNum(n);
                rent = rent + car.chooseCar_rent(n);
                pNamelist.add(car.chooseCar_passenger(n));
                lNamelist.add(car.chooseCar_load(n));//列表里会存null，不会为空。
            }
            System.out.println("请输入租车天数：");
            int day = input.nextInt();
            int allRent = rent * day;
            System.out.println("***以下是您的账单：");

                for (String name : pNamelist) {
                    System.out.print(" " + name + "  ");

                }
                System.out.print(" 共载人：" + pNum + "人\n");

               // System.out.println("       ***");



                for (String name : lNamelist) {
                    System.out.print(" " + name + "  ");
                }
                System.out.print(" 共载货：" + lNum + "吨\n");

               // System.out.println("      ***");

            System.out.println("***租车价格为：" + allRent + "元！");
        }
    }









    }


