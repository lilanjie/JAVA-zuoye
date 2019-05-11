package com.carsharing.trip;
import  com.carsharing.location.Point;

public class Trip {

    private int time;
    private Point orign;
    private Point destination;

    public Trip (int time, Point orign, Point destination){
        this.time = time;
        this.orign = orign;
        this.destination = destination;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int name) {
        this.time = name;
    }

    public Point getOrign() {
        return orign;
    }

    public void setOrign(Point score) {
        this.orign = orign;
    }

    public Point getDestination() { return destination; }

    public void setDestination(Point destination) {
        this.destination = destination;
    }

    public static int creattime(){
        int departtime = (int)(Math.random()*108);
        return departtime;
    }

    public static Point creatorign(){
        int x=(int)(Math.random()*8800);
        int y=(int)(Math.random()*8800);
        Point orign = new Point(x,y);
        return orign;
    }

    public static Point creatdestination(){
        int x=(int)(Math.random()*8800);
        int y=(int)(Math.random()*8800);
        Point destination = new Point(x,y);
        if(getDistence(Point this.orign,Point this.destination) >1000){
            return destination;
        }
    }
}
