package com.carsharing.location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hypothesis {
    //Station[] station = Station.readFromFile("station1");
    //User[] user = Usergenerator.readFromFile("user1");

    public static void main(String[] args) {
        Hypothesis hypothesis = new Hypothesis();
        hypothesis.getHypothesis();

    }


    public void getHypothesis() {
        Station[] station = Station.Creatlocation();
        User[] user = Usergenerator.RandomCreate();
        for (int n = 0; n < user.length; n++) {
            List<Station> p1List = new ArrayList<>();
            Map<User, List<Station>> userListMap1 = new HashMap<>();
            double Oclosedis1 = Point.getDistance(station[0].getLocation(), user[n].getOrign());
            Station station1 = station[0];
            for (int i = 0; i < station.length; i++) {
                double Oclosedis = Point.getDistance(station[i].getLocation(), user[n].getOrign());
                if (Oclosedis <= Oclosedis1) {
                    Oclosedis1 = Oclosedis;
                    station1 = station[i];
                }
            }
            p1List.add(0,station1);
            //System.out.print(station1.getLocation());
            //System.out.print("最站点近：" + station1.getLocation());
            double Oclosedis2 = Point.getDistance(station[0].getLocation(), station1.getLocation());
            Station station2 = station[0];
            for (int j = 0; j < station.length; j++) {
                double Osecondclose = Point.getDistance(station[j].getLocation(), station1.getLocation());
                if (Osecondclose <= Oclosedis2 & Osecondclose != 0) {
                    Oclosedis2 = Osecondclose;
                    station2 = station[j];
                }
            }
            p1List.add(1, station2);
            //System.out.print(station2.getLocation());
            double Oclosedis3 = Point.getDistance(station[0].getLocation(), station2.getLocation());
            Station station3 = station[0];
            for (int m = 0; m < station.length; m++) {
                double Othirdclose = Point.getDistance(station[m].getLocation(), station2.getLocation());
                if (station[m] != station1 & station[m]!=station2 & Othirdclose <= Oclosedis3) {
                    Oclosedis3 = Othirdclose;
                    station3 = station[m];
                }
            }
            p1List.add(2, station3);
            //System.out.print(station3.getLocation());
            userListMap1.put(user[n], p1List);
            for (Map.Entry<User,List<Station>>userListEntry:userListMap1.entrySet() ){
                userListEntry.getKey();
                userListEntry.getValue();
                System.out.print("离用户出发地："+userListEntry.getKey().getOrign()+"的最近三个站点是：\n"+userListEntry.getValue().get(0).getLocation()+"\n"+userListEntry.getValue().get(1).getLocation()+"\n"+userListEntry.getValue().get(2).getLocation()+"\n");//map getValue 怎么取到用户信息？
            }`1

            List<Station> p2List = new ArrayList<>();
            Map<User, List<Station>> userListMap2 = new HashMap<>();
            double Dclosedis1 = Point.getDistance(station[0].getLocation(), user[n].getDestination());
            Station station4 = station[0];
            for (int i = 0; i < station.length; i++) {
                double Dclosedis = Point.getDistance(station[i].getLocation(), user[n].getDestination());
                if (Dclosedis <= Dclosedis1) {
                    Dclosedis1 = Dclosedis;
                    station4 = station[i];
                }
            }
            p2List.add(0,station4);
            //System.out.print(station4.getLocation());
            double Dclosedis2 = Point.getDistance(station[0].getLocation(), station4.getLocation());
            Station station5 = station[0];
            for (int j = 0; j < station.length; j++) {
                double Dsecondclose = Point.getDistance(station[j].getLocation(), station4.getLocation());
                if (station[j] != station4 & Dsecondclose <= Dclosedis2) {
                    Dclosedis2 = Dsecondclose;
                    station5 = station[j];
                }
            }
            p2List.add(1,station5);
            //System.out.print(station5.getLocation());
            double Dclosedis3 = Point.getDistance(station[0].getLocation(), station5.getLocation());
            Station station6 = station[0];
            for (int m = 0; m < station.length; m++) {
                double Dthirdclose = Point.getDistance(station[m].getLocation(), station5.getLocation());
                if (station[m] != station4 & station[m]!= station5 & Dthirdclose <= Dclosedis3) {
                    Dclosedis3 = Dthirdclose;
                    station6 = station[m];
                }
            }
            p2List.add(2,station6);
            //System.out.print(station6.getLocation());
            userListMap2.put(user[n], p2List);
            for (Map.Entry<User,List<Station>>userListEntry:userListMap2.entrySet() ){
                userListEntry.getKey();
                userListEntry.getValue();
                System.out.print("离用户目的地："+userListEntry.getKey().getDestination()+"的最近三个站点是：\n"+userListEntry.getValue().get(0).getLocation()+"\n"+userListEntry.getValue().get(1).getLocation()+"\n"+userListEntry.getValue().get(2).getLocation()+"\n");//map getValue 怎么取到用户信息？
            }
        }
    }
}