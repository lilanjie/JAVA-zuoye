package com.carsharing.location;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.carsharing.location.Point;

public class Station {
    Point station;

    public static Station Creatlocation() {
        List<Point> list = new ArrayList<Point>();

        for (int i = 1; i < 12; i++) {
            for (int j = 1; j < 12; j++) {
                Point station = new Point(400 * i, 400 * j);
                list.add(station);
            }

        }
        return new Station();
    }

    public void print() {

        System.out.println("站点x:" + station.getX() + "y:" + station.getY());

    }


    public void writeToFile(String name) {
        try {
            FileOutputStream fs = new FileOutputStream(name);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(this);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Station readFromFile(String name) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(name));
            Station station = (Station) objectInputStream.readObject();
            objectInputStream.close();
            return station;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Station station = Station.Creatlocation();
        station.print();
        station.writeToFile("station");
    }
}



