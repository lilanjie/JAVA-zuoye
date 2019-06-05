package com.carsharing.location;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.carsharing.location.Point;

public class Station {
    private Point location;
    private Integer carnum;

    public Station(Point location, Integer carnum) {
        this.location = location;
        this.carnum = carnum;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Integer getCarnum() {
        return carnum;
    }

    public void setCarnum(Integer carnum) {
        this.carnum = carnum;
    }

    public static Station[] Creatlocation() {

        Station[] stations = new Station[4];
        //List<Station> stationListlist = new ArrayList<>();
        int n = 0;
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                Point location = new Point(400 * i, 400 * j);
                Integer carnum = (int) (Math.random() * 5);
                Station station = new Station(location,carnum);
                station.setLocation(location);
                //stationListlist.add(n,station);
                stations[n] = station;
                System.out.println("站点:" + station.getLocation() + " 初始车辆：" + station.getCarnum());
                n++;
            }
        }

        return stations;
    }

    }







