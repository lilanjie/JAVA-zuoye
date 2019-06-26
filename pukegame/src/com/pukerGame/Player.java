package com.pukerGame;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Player {

    private int ID;
    private String name;
    public List<PuKer> puKerList;
    public Scanner input;

    public Player() {
        input = new Scanner(System.in);
        this.puKerList = new ArrayList<>();


    }


    public Player(int id, String name) {
        this.ID = id;
        this.name = name;
        this.puKerList = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * ID 输入异常处理
     * @return
     */
    public int inputID() {
        for (; ; ) {
            try {
                Scanner in = new Scanner(System.in);
                System.out.println("输入ID：");
                int id = in.nextInt();
                return id;
            } catch (InputMismatchException e) {
                System.out.println("请输入整数类型的ID！");
                continue;
            }
        }
    }

    public void playGame() {
        //创建两位玩家
        Scanner input = new Scanner(System.in);
        System.out.println("请输入第一位玩家的ID和姓名：");
        Player player1 = new Player();
        player1.setID(inputID());
        System.out.println("请输入姓名：");
        player1.setName(input.next());
        System.out.println("请输入第二位玩家的ID和姓名：");
        Player player2 = new Player();
        player2.setID(inputID());
        System.out.println("请输入姓名：");
        player2.setName(input.next());
        System.out.println(player1.getID() + "." + player1.getName());
        System.out.println(player2.getID() + "." + player2.getName());
        //创建一副扑克牌
        PuKer puKer = new PuKer();
        List<PuKer> puKers = puKer.creatADeck();
        System.out.println("-------------开始发牌--------------");
        System.out.println(player1.getName() + "-拿牌");
        player1.puKerList.add(puKers.get(0));
        System.out.println(player2.getName() + "-拿牌");
        player2.puKerList.add(puKers.get(1));
        System.out.println(player1.getName() + "-拿牌");
        player1.puKerList.add(puKers.get(2));
        System.out.println(player2.getName() + "-拿牌");
        player2.puKerList.add(puKers.get(3));
        System.out.println("-------------发牌结束--------------");

        System.out.println("-------------开始游戏--------------");
        PuKer puKer1 = puKers.get(0).compare(puKers.get(2));
        System.out.println("玩家"+player1.getName()+"最大的手牌为：" +puKer1.toString());
        PuKer puKer2 = player2.puKerList.get(0).compare(player2.puKerList.get(1));
        System.out.println("玩家"+player2.getName()+"最大的手牌为：" +puKer2.toString());
        PuKer puKer3 = puKer1.compare(puKer2);
        if(puKer3 ==puKer1){
            System.out.println("------玩家："+player1.getName()+"获胜--------");
        }else {
            System.out.println("------玩家："+player2.getName()+"获胜--------");
        }
        System.out.println("玩家各自的手牌为：");
        System.out.println(player1.puKerList.toString());
        System.out.println(player2.puKerList.toString());

    }
}
