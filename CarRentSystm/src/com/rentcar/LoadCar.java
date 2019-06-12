package com.rentcar;

public class LoadCar extends Car {
    private int loadCap;

    public LoadCar(int num, String name, int loadCap, int rentPrice){
        super.setNum(num);
        super.setName(name);
        super.setRentPrice(rentPrice);
        this.loadCap = loadCap;
    }

    public int getLoadCap() {
        return loadCap;
    }

    public void setLoadCap(int loadCap) {
        this.loadCap = loadCap;
    }

    @Override
    public String toString() {
        return getNum()+"\t" +getName()+"\t"+getRentPrice()+"/天\t"+"载货"+loadCap+"吨";
    }
}
