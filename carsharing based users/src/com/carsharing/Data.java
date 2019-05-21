package com.carsharing;
import com.carsharing.location.Point;

public class Data {
    //从文件中读取的数据
    int stationnumber;//车站数量
    int users;//用户数量
    int time;

    Point [] stationcoordinates;//车站坐标
    Point [] usercoordinates;//用户坐标

    Point  orign;//原点
    Point destination;//终点

    int [] user;//用户编号
    double []departtime;//用户出发时间
    double [][]walkforcar;

    int p1station ;
    int p2station ;//情况不同，值不同


    //直接定义数据
    int beginday = 0;//一天的开始
    int endday = 107;//一天的结束

    double drivepay = 2;//用户每时间步长的用车费用
    double parkcost = 5;//每天每车位停车费
    double drivecost = 17.35;//每公里耗油费
    double vehiclecost = 0.07;//每天车辆折旧费
    int parknumber = 3;


    int vehiclenumber;


   //定义函数计算
    double walktime;
    double []begindrivetime;
    double [][] topark;//第二种情况下开车找车站的时间
    double [][] distance;//用户开车行驶距离
    //double [][][] drivetime;



}
