package com.pukerGame;

import java.util.*;

public class PuKer {

    private String color;
    private String point;
    public String[] points = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public PuKer(String color,String point){
        this.color = color;
        this.point = point;
    }
    public PuKer(){

    }

    /**
     * 获得String数组对应元素的下标
     * @param str
     * @return
     */

    public int getIndex(String str){
        //String[] points = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        int i = 0;
        while (i<points.length){
            if(points[i].equals(str)){
                return i;
            }
            i++;
        }
        return i;
    }

    public PuKer compare(PuKer puKer) {
        //通过比较在数组中的下标来比较扑克牌的点数大小
        int a = getIndex(this.getPoint());
        int b = getIndex(puKer.getPoint());
        if(a>b) {
            return this;
        }
        if(a<b){
            return puKer;
        }else {
            if (this.color.equals("黑桃")){
                return this;
            }else if(puKer.color.equals("黑桃")){
                return puKer;
            }else if(this.color.equals("红桃")){
                return this;
            }else if(puKer.color.equals("红桃")) {
                return puKer;
            }else if(this.color.equals("梅花")){
                return this;
            }else if(puKer.color.equals("梅花")) {
                return puKer;
            }else
                return this;
            }

        }



    public List<PuKer> creatADeck(){
        System.out.println("-------------创建扑克牌---------------------");
        List<PuKer> puKerList = new ArrayList<>();

        for (int i = 0 ; i < points.length; i++){
            puKerList.add(new PuKer("黑桃",points[i]+""));
        }
        for (int i = 0 ; i < points.length; i++){
            puKerList.add(new PuKer("红桃",points[i]+""));
        }
        for (int i = 0 ; i < points.length; i++){
            puKerList.add(new PuKer("梅花",points[i]+""));
        }
        for (int i = 0 ; i < points.length; i++){
            puKerList.add(new PuKer("方片",points[i]+""));
        }
        System.out.println("------------扑克牌创建成功----------------");
        System.out.println(puKerList.toString());
        System.out.println("--------------开始洗牌------------------");
        Collections.shuffle(puKerList);
        System.out.println(puKerList.toString());
        return puKerList;
    }

    @Override
    public String toString() {
        return  color +
                 point ;
    }
}
