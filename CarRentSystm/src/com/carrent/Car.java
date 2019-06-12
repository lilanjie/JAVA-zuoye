package com.carrent;


public class Car {
    Aodi aodi = new Aodi();
    Mzida mzida = new Mzida();
    Pikaxue pikaxue = new Pikaxue();
    Jinlong jinlong = new Jinlong();
    Songhuajiang songhuajiang = new Songhuajiang();
    Yiweike yiweike = new Yiweike();

    public void showCar(){
        System.out.println("您可租车的类型及其价目表：");
        System.out.println("序号  汽车名称    租金     容量");
        aodi.print();
        mzida.print();
        pikaxue.print();
        jinlong.print();
        songhuajiang.print();
        yiweike.print();
    }
    public int chooseCar_pNum(int n ){
        int pNum = 0;
        switch (n){
            case 1:
                pNum = aodi.passengers;
                break;
            case 2:
                pNum = mzida.passengers;
                break;
            case 3:
                pNum = pikaxue.passengers;
                break;
            case 4:
                pNum = jinlong.passengers;
                break;
            case 5:
                pNum = 0;
                default:pNum = 0;
        }
        return pNum;
        }
    public int chooseCar_lNum(int n ){
        int lNum = 0;
        switch (n){
            case 1:
                lNum = 0;
                break;
            case 2:
                lNum = 0;
                break;
            case 3:
                lNum = pikaxue.load;
                break;
            case 4:
                lNum = 0;
                break;
            case 5:
                lNum = songhuajiang.load;
            default:lNum = yiweike.load;
        }
        return lNum;
    }
    public int chooseCar_rent(int n ){
        int rent = 0;
        switch (n){
            case 1:
                rent= 500;
                break;
            case 2:
                rent= 400;
                break;
            case 3:
                rent= 450;
                break;
            case 4:
                rent= 800;
                break;
            case 5:
                rent= 400;
                break;
            default:rent= 1000;
        }
        return rent;
    }
    public String chooseCar_passenger(int n ) {
        String name = null;
        switch (n) {
            case 1:
                name = aodi.name;
                break;
            case 2:
                name = mzida.name;
                break;
            case 3:
                name = pikaxue.name;
                break;
            case 4:
                name = jinlong.name;
                break;
        }
        return name;
    }
    public String chooseCar_load(int n ) {
        String name = null;
        switch (n){
            case 3:
                name = pikaxue.name;
                break;
            case 5:
                name = songhuajiang.name;
                break;
            case 6:
                name = yiweike.name;
                break;
        }
        return name;
    }


    }





    /*
    public  int orderNum;
    public  int rent;
    public  String vehicleType;
    public  void print(){
        System.out.print( orderNum+"     "+vehicleType+"    "+rent+"/天  ");
    }

    public static void creatCar(){
        System.out.println("序号  汽车名称    租金     容量");
        Car car1 = new MannedVehicle();
        car1.orderNum =1;
        car1.vehicleType = "奥迪A6 ";
        car1.rent = 500;
        ((MannedVehicle) car1).passengerNum = 4;
        car1.print();
        Car car2 = new MannedVehicle();
        car2.orderNum=2;
        car2.vehicleType = "马自达6";
        ((MannedVehicle) car2).passengerNum = 4;
        car2.rent = 400;
        car2.print();
        Car car3 = new BothCar();
        car3.orderNum = 3;
        car3.rent = 450;
        car3.vehicleType = "皮卡雪6";
        car3.print();
        Car car4 = new MannedVehicle();
        car4.vehicleType = "金龙   ";
        car4.rent = 800;
        car4.orderNum = 4;
        ((MannedVehicle) car4).passengerNum = 20;
        car4.print();
        Car car5 = new Truck();
        car5.vehicleType = "松花江 ";
        ((Truck) car5).load = 4;
        car5.rent = 400;
        car5.orderNum = 5;
        car5.print();
        Car car6 = new Truck();
        car6.vehicleType = "依维柯 ";
        car6.rent = 1000;
        ((Truck) car6).load = 20;
        car6.orderNum = 6;
        car6.print();

    }
    public void calculate() {

    }
    public static void chooseCar(int n ){
        int pNum = 0;
        int lNum = 0;
        if(n==1){
            String name = "奥迪A6";
            int num = 4;
            pNum = pNum + num;
        }
        if(n==2){
            String name = "";
            int num = 4;
            pNum = pNum + num;
        }
        if(n==3){
            int num = 4;
            int l = 2;
            pNum = pNum + num;
            lNum = lNum + l;
        }
        if(n==4){
            int num = 20;
            pNum = pNum + num;

        }
        if(n==5){
           int  l = 4;
            lNum = lNum + l;
        }
        if(n==6){
            int  l = 20;
            lNum = lNum + l;
        }

    }
       // int pNum = 0;
       // int lNum = 0;
        /*
        switch (n){
            case 1:
                Car car1 = new MannedVehicle();
                car1.orderNum =1;
                car1.vehicleType = "奥迪A6 ";
                car1.rent = 500;
                ((MannedVehicle) car1).passengerNum = 4;
                //car1.print();
                //pNum = pNum + ((MannedVehicle) car1).passengerNum;
                //System.out.print(" 奥迪A6 ");
                break;
            case 2:
                Car car2 = new MannedVehicle();
                car2.orderNum=2;
                car2.vehicleType = "马自达6";
                ((MannedVehicle) car2).passengerNum = 4;
                car2.rent = 400;
                //car2.print();
               // pNum = pNum + ((MannedVehicle) car2).passengerNum;
                //System.out.print(" 马自达6 ");
                break;
            case 3:
                Car car3 = new BothCar();
                car3.orderNum = 3;
                car3.rent = 450;
                car3.vehicleType = "皮卡雪6";
                //car3.print();
                //pNum = pNum + ((BothCar) car3).passengerNum;
                //lNum = lNum + ((BothCar) car3).load;
                //System.out.print(" 皮卡雪6 ");
                break;
            case 4:
                Car car4 = new MannedVehicle();
                car4.vehicleType = "金龙   ";
                car4.rent = 800;
                car4.orderNum = 4;
                ((MannedVehicle) car4).passengerNum = 20;
                //pNum = pNum + ((MannedVehicle) car4).passengerNum;
                //car4.print();
                //System.out.print(" 金龙 ");
                break;
            case 5:
                Car car5 = new Truck();
                car5.vehicleType = "松花江 ";
                ((Truck) car5).load = 4;
                car5.rent = 400;
                car5.orderNum = 5;
                //car5.print();
               // lNum = lNum + ((Truck) car5).load;
                //System.out.print(" 松花江 ");
                break;
                default:
                    Car car6 = new Truck();
                    car6.vehicleType = "依维柯 ";
                    car6.rent = 1000;
                    ((Truck) car6).load = 20;
                    car6.orderNum = 6;
                    //car6.print();
                   // lNum = lNum + ((Truck) car6).load;
                    //System.out.print(" 依维柯 ");
                    break;
        }// System.out.print(" 共载人"+ pNum+"人\n");
    }
    */

