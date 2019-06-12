package com.rentcar;

//父类，声明了子类共有的属性，并进行封装，该父类也可以是抽象类abstract
//set和get，可以通过系统自动生成。
public class Car {
    private int num;
    private int rentPrice;
    private String name;


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
