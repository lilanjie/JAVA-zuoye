package com.carsharing.location;

public class Stationlocation {
    private Point point;

    public Stationlocation(Point point){
        super();
        this.point = point;
    }

    public void setPoint(Point point){
        this.point = point;
    }

    public Point getPoint(){
        return point;
    }

    public  Point Creatlocation(){

        for (int i = 1; i < 12; i++){
            for (int j = 1; j <12; j++){
                Point point= new Point(400*i,400*j);
            }

        }
        return point;
    }
    public void print() {

        System.out.println(this.point);

    }

    public static void main(String[] args) {

        Stationlocation stationlocation = new Stationlocation();
        stationlocation = new Stationlocation();
        Point p = stationlocation.Creatlocation();
        System.out.println(p);


    }



}
