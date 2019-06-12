package com.rentcar;

public class PassengerCar extends Car {
    private int passengers;

    public PassengerCar(int num,String name,int passengers,int rentPrice) {
        super.setNum(num);
        super.setName(name);
        super.setRentPrice(rentPrice);
        this.passengers = passengers;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return getNum()+"\t" +getName()+"\t"+getRentPrice()+"/天\t"+"载人"+passengers+"人";
    }
}
