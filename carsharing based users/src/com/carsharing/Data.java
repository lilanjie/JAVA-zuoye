package com.carsharing;

public class Data {
    int stationnumber;//车站数量
    int [] station;//车站编号
    int p1station = 3;
    int p2station = 3;
    int parknumber;//一个车站的停车位数量
    int [] park;
    int [] vehicle;
    int vehiclenumber;//车辆数
    int users;//用户数量
    int [] user;//用户编号
    int  orign;//原点
    int destination;//终点
    int beginday = 0;//一天的开始
    int endday = 107;//一天的结束
    int time ;//
    int stationtime;//时空节点
    double departtime;//用户出发时间
    double [][] walktime;
    double parktime;
    double [][][] drivetime;//用户开车行驶时间
    double [][] distance;//用户开车行驶距离
    double drivepay = 2;//用户每时间步长的用车费用
    double parkcost = 5;//每天每车位停车费
    double drivecost = 17.35;//每公里耗油费
    double vehiclecost = 0.07;//每天车辆折旧费
    //是否需要为用户建个class



}
