package com.carsharing.location;

public class Point {

    private int x;
    private int y;

    public Point (int x,int y){
        super();
        this.x = x;
        this.y = y;
    }

    public static double getDistance(Point m, Point n) {

        return Math.sqrt(Math.pow(m.x - n.x, 2) + Math.pow(m.y - n.y, 2));

    }
    public void setX(int x){
        this.x = x;
    }

    public int getX(){
        return x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getY(){
        return y;
    }

    public static Point randomCreate(){
        int x=(int)(Math.random()*8800);
        int y=(int)(Math.random()*8800);
        return new Point(x,y);
    }


    }

