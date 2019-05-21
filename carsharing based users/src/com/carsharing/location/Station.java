package com.carsharing.location;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.carsharing.location.Point;

public class Station {
    private Point location;
    public Station(Point location){
        this.location = location;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public static Station[] Creatlocation() {
        Station[] stations =  new Station[121];
        /*java.util.List<Point> pointList= new ArrayList<>();
        */
            for (int i = 1; i < 12; i++) {
                for (int j = 1; j < 12; j++) {
                    Point location =  new Point(400 * i, 400 * j);
                    Station station = new Station(location);
                    station.setLocation(location);
                    stations[i*11+j] = station;
                    System.out.println("站点:" + station.getLocation());
                }
            }

        return stations;
    }

    public static void writeToFile(String name) {
        try {
            FileOutputStream fs = new FileOutputStream(name);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            Station[] stations = new Station[121];
            os.writeObject(stations);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Station[] readFromFile(String name) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(name));
            Station[] stations = (Station[]) objectInputStream.readObject();
            objectInputStream.close();
            return stations;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Station.Creatlocation();
        Station.writeToFile("station");
    }
}




