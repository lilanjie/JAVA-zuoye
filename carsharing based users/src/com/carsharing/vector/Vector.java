package com.carsharing.vector;

import com.carsharing.Data;
import com.carsharing.location.*;
import com.carsharing.location.Hypothesis;

public class Vector {

    Station[] station = Station.readFromFile("station1");
    User[] user = Usergenerator.readFromFile("user1");

    int stationnum = station.length;
    int usernum = user.length;
    int timestep = 108;

    int nodeST[][] = new int[stationnum][timestep];//时空节点
    int departTime[] = new int[timestep]; //用户文件读出来的
    double walkForcar[][] = new double[usernum][stationnum];//需要计算原点和站点之间的距离
    double driveForpark[][] = new double[usernum][stationnum];//分情况讨论
    double walkTodes[][] = new double[usernum][stationnum];//计算停车站点到目的地之间的距离
    double beginDrive[][] = new double[usernum][stationnum];//加时间
    //double driveTime[][][] = new double[timestep][stationnum][stationnum];//分时间段计算时间
    double driveDistence[][] = new double[stationnum][stationnum];//计算距离



    public int[] getDepartTime() {
        for (int n = 0; n < usernum; n++) {
            departTime[n] = user[n].getDeparttime();
        }
        return departTime;
    }

    public double[][] getWalkForcar() {
        //double walkForcar[][] = new double[usernum][stationnum];
        for (int n = 0; n < usernum; n++) {
            for (int i = 0 ; i < stationnum;i++) {//这部分需要修改
                walkForcar[n][i] = Point.getDistance(user[n].getOrign(), station[i].getLocation())/1000;
            }
        }
            return walkForcar;
    }

    public double[][] getBeginDrive() {
        for (int n = 0; n < usernum; n++){
            for (int i = 0; i < stationnum; i++){//怎么修改呢
                beginDrive[n][i] = departTime[n] + walkForcar[n][i];
            }
        }
        return beginDrive;
    }



    public double[][] getDriveDistence() {
            //double[][] driveDistence = new double[stationnum][stationnum];
        for (int i = 0; i < stationnum; i++) {
            for (int j = 0; j < stationnum; j++) {
                    driveDistence[i][j] = Point.getDistance(station[i].getLocation(), station[j].getLocation());
                    driveDistence[j][i] = driveDistence[i][j];
            }
        }
        return driveDistence;
    }

    public double[][][] getDriveTime() {
        double driveTime[][][] = new double[departTime.length][stationnum][stationnum];
        for (int n = 0; n < usernum; n++) {
            for (int i = 0; i < stationnum; i++) {//这里不太对
                for (int j = 0; j < stationnum; j++) {
                    if ((departTime[n]>=12 & departTime[n]<=25)||(departTime[n]>=72 & departTime[n]<=84)){
                        driveTime[departTime[n]][i][j] = driveDistence[i][j]/3500;
                    }
                    else {
                        driveTime[departTime[n]][i][j] = driveDistence[i][j]/5000;
                    }
                }
            }
        }
        return driveTime;
    }

    public double[][] getDriveForpark() {//有可能为0

        return driveForpark;
    }

    public double[][] getWalkTodes() {

        for (int n = 0; n < usernum; n++) {
            for (int i = 0 ; i < stationnum;i++) {//这部分需要修改
                walkTodes[n][i] = Point.getDistance(user[n].getDestination(), station[i].getLocation())/1000;
            }
        }
        return walkTodes;
    }

    public int[][] getNodeST() {
        for(int i = 0 ; i < stationnum; i++){
            for (int t = 1; t < timestep; t++){
                nodeST[i][t] = nodeST[i][t];//不知道自己写的什么鬼
            }
        }
        return nodeST;
    }
}

