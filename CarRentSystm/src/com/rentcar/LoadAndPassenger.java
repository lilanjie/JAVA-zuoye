package com.rentcar;

//Car 的一个子类，同理，进行封装。
public class LoadAndPassenger extends Car {
    public int passengers;
    public int loadCap;

    public LoadAndPassenger(int num, String carType, int passengers, int loadCap, int rentPrice){
        super.setNum(num);//访问父类属性的写法
        super.setName(carType);
        super.setRentPrice(rentPrice);
        this.loadCap = loadCap;
        this.passengers = passengers;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getLoadCap() {
        return loadCap;
    }

    public void setLoadCap(int loadCap) {
        this.loadCap = loadCap;
    }

    @Override
    public String toString() {
        return getNum()+"\t" +getName()+"\t"+getRentPrice()+"/天\t"+"载人"+passengers+"人，载货"+loadCap+"吨";

    }
}
