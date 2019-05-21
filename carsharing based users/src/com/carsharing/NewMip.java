package com.carsharing;
import com.carsharing.location.Point;
import com.carsharing.solution.Solution;
import ilog.concert.IloException;//处理异常
import ilog.concert.IloNumExpr; //数值表达式
import ilog.concert.IloNumVar; //为任何类型的数值变量定义API
import ilog.concert.IloNumVarType; //建模变量的类型
import ilog.cplex.IloCplex;//


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


public class NewMip {
    Data data;
    IloCplex cplex;
    double begindrivetime;
    public IloNumVar[][][][][] X;//二元决策变量
    public IloNumVar[][] y;//二元决策变量
    public IloNumVar[][][]S;
    //public IloNumVar[][]departtime;
    /*public IloNumVar [][][] drivetime;
    public IloNumVar [][] distance;
    public IloNumVar[][] a;
    public IloNumVar[][] P;
    public IloNumVar  walktime;
    */
    IloNumExpr[][][] drivetime = new IloNumExpr[data.time][data.stationnumber][data.stationnumber];
    IloNumExpr[][] drivedistance = new IloNumExpr[data.stationnumber][data.stationnumber];
    IloNumExpr[][] walktime = new IloNumExpr[data.users][data.stationnumber];
    IloNumExpr[][] a = new IloNumExpr[data.stationnumber][data.time];
    IloNumExpr[][] topark = new IloNumExpr[data.stationnumber][data.users];


    double profit;
    Solution solution;
    public  NewMip(Data data){
        this.data = data;
    }
    //解模型
    public void solve() throws IloException{
        if(cplex.solve() == false) {
            System.out.println("problem should not solve false");
            return;
        }
        else {
        }
        solution = new Solution();
        profit = cplex.getObjValue();
        System.out.println("");
    }
    //建立模型
    public void build_cplex() throws IloException{

            cplex = new IloCplex();

            cplex.setOut(null);
            X = new IloNumVar[data.users][data.stationnumber][data.time][data.stationnumber][data.time];
            y = new IloNumVar[data.parknumber][data.stationnumber];
            S = new IloNumVar[data.stationnumber][data.time][data.time];
            //departtime = new IloNumVar[data.users][data.stationnumber];
            /*a = new IloNumVar[data.stationnumber][data.time];
            drivetime = new IloNumVar[data.time][data.stationnumber][data.stationnumber];
            distance = new IloNumVar[data.stationnumber][data.stationnumber];
             walktime = new IloNumVar;
             P = new IloNumVar[data.parknum][data.station];
            */


            //定义0-1变量
            for (int n = 0; n < data.users; n++) {
                for (int i = 0; i < data.p1station; i++) {
                    for (int j = 0; j < data.p2station; j++) {
                        for (int t = 0; t < data.time; t++) {
                            for (int tj = t; tj < data.time; tj++) {
                                X[n][i][t][j][tj] = cplex.numVar(0, 1, IloNumVarType.Int, "X" + n + "," + i + "," + t + "," + j + "," + tj);
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < data.stationnumber; i++) {
                y[i][data.parknumber] = cplex.numVar(0, 1, IloNumVarType.Int, "y" + i + "," + data.parknumber);
            }

            //加入目标函数

            IloNumExpr obj = cplex.linearNumExpr();//
            IloNumExpr allpark = cplex.numExpr();//所有的停车位
            IloNumExpr allvehicle = cplex.numExpr();//所有的车辆
            IloNumExpr driveprofit = cplex.numExpr();

            for (int i = 0; i < data.stationnumber; i++) {
                allpark = cplex.sum(allpark, cplex.prod(y[i][data.parknumber], data.parknumber));
                allvehicle = cplex.sum(allvehicle, a[i][0]);
                for(int t=0; t < data.time; t++){
                    cplex.addLe(a[i][t],allpark);//约束（7）
                }

            }
            for (int n =0 ; n < data.users; n++) {
                for (int i = 0; i < data.p1station; i++) {
                    for (int j = 0; j < data.p2station; j++) {
                        for (int t = 0; t < data.time; t++) {
                            for (int tj = t; tj < data.time; tj++) {
                       // begindrivetime = departtime[n][i] + walktime;
                                driveprofit = cplex.sum(driveprofit, cplex.prod(X[n][i][t][j][tj], cplex.sum(cplex.prod(data.drivepay, drivetime[data.time][i][j]), (cplex.prod(-data.drivecost, drivedistance[i][j])))));
                            }
                        }
                    }
                }
            }

            obj = cplex.sum(driveprofit, cplex.prod(-data.parkcost, allpark), cplex.prod(-data.vehiclecost, allvehicle));
            cplex.addMaximize(obj);


            //加入约束（2）
            /*IloNumExpr expr2 = cplex.numExpr();
            IloNumExpr[][] begindrivetime = new IloNumExpr[data.users][data.stationnumber];
            for (int n=0; n< data.users; n++) {
                for (int i = 0; i < data.p1station; i++) {
                    expr2 = cplex.sum(data.departtime[n], walktime[n][i]);
                    cplex.addEq(begindrivetime[n][i],expr2);
                }
            }
            */
            //公式（3）
            IloNumExpr expr3 = cplex.numExpr();
           // IloNumExpr expr4 = cplex.numExpr();
            //IloNumExpr expr5 = cplex.numExpr();
            IloNumExpr arrivecar = cplex.numExpr();
            IloNumExpr leavecar = cplex.numExpr();
            int t0 ;
            int t1 ;
            for(int n = 0; n < data.users; n++) {
                for (int t=1; t < data.time; t++){
                    for (int i = 0; i < data.p2station; i++) {
                        for (int j = 0; j < data.p1station; j++) {
                            t0 = cplex.sum(t,cplex.prod(-1,drivetime[t0][j][i]),cplex.prod(-1,topark[n][j]));//(4)
                            arrivecar = cplex.sum(arrivecar, X[n][j][t0][i][t]);
                        }
                    }
                    for (int i = 0; i < data.p1station; i++) {
                        for (int j = 0; j < data.p2station; j++) {
                            t1 = cplex.sum(t,-1,drivetime[t-1][j][i],topark[n][i]);//(5)
                            leavecar = cplex.sum(leavecar, X[n][i][t-1][j][t1]);
                        }
                    }
                }

            }
            for( int i =0 ; i < data.p1station; i++) {
                for (int t =1; t < data.time; t++){
                    expr3 = cplex.sum(a[i][t - 1], arrivecar, cplex.prod(-1, leavecar));
                    cplex.addEq(a[i][t],expr3);//????????
                }
            }

            //(6)
            IloNumExpr expr6 = cplex.numExpr();
            IloNumExpr leaveitcar = cplex.numExpr();
            for (int n = 0; n < data.users; n++) {
                for (int i = 0; i < data.p1station; i++) {
                    for (int j = 0; j < data.p2station; j++) {
                        for(int t =0; t < data.time; t ++){
                            leaveitcar = cplex.sum(leaveitcar,X[n][i][t][j][t2]);
                            expr6 = cplex.sum( a[i][t],cplex.prod(-1,leaveitcar));
                            cplex.addEq(S[i][t][t+1],expr6);
                        }

                    }

                }
            }

            //(8)
            IloNumExpr expr8 = cplex.numExpr();
            for (int n = 0; n < data.users; n++) {
                for (int i = 0; i < data.p1station; i++) {
                    for (int j = 0; j < data.p1station; j++) {
                        for (int t = 0; t< data.time; t++){
                            double t2;
                            t2 = t + drivetime[begindrivetime[n][i]][i][j]+topark[j][data.users];
                            expr8 = cplex.sum(expr8, X[n][i][t][j][t2]);
                        }
                    }
                }
            }
            cplex.addLe(expr8,1);
            //（9）
            IloNumExpr expr9 = cplex.numExpr();
            for (int i = 0; i < data.stationnumber; i++) {
                expr9 = cplex.sum(expr9,y[i][data.parknumber]);
            }
            cplex.addLe(expr9,1);
            //从文件中读取数据并初始化参数
        public static void process_example(String path,Data data,int stationnumber) throws Exception{
            String line = null;
            String[] substr = null;
            Scanner cin = new Scanner(new BufferedReader(new FileReader(path)));
            for (int i = 0; i <4 ; i ++){
                line = cin.nextLine();//读取一行
            }
            line = cin.nextLine();
            line.trim();
            substr = line.split("\\s+");
            //初始化参数
            data.stationnumber = stationnumber;
            data.users = Integer.parseInt(substr[1]);
            data.vehiclenumber = Integer.parseInt(substr[2]);
            data.stationcoordinates = new Point[data.stationnumber];
            data.usercoordinates = new Point[data.users];
            data.user = new int[data.stationnumber];
            data.drivetime = new double[data.time][data.stationnumber][data.stationnumber];
            data.distance = new double[data.stationnumber][data.stationnumber];
            //data.departtime = new double[data.time];
            data.begindrive = new double[data.time];
            //距离矩阵
            data.distance = new double[data.stationnumber][data.stationnumber];
            for (int i =0; i <4; i++){
                line = cin.nextLine();
            }
            //读取stationnumber-1行数据?
            for (int i = 0; i< data.stationnumber -1;i++){
                line = cin.nextLine();
                line.trim();
                substr = line.split("\\s+");
                data.usercoordinates[i][0] = Integer.parseInt(substr[2]);
                data.stationcoordinates[i][1] = Integer.parseInt(substr[3]);
                data.drivetime[i] = Integer.parseInt(substr[4]);
                data.distance[i] = Integer.parseInt(substr[5]);
                data.begindrive[i] = Integer.parseInt(substr[6]);

            }
            cin.close();
            //初始化车站参数
            data.park[data.stationnumber] = 3;
            data.beginday = 0;
            data.endday = 107;
            //距离矩阵初始化？

            //距离矩阵满足三角关系？

            //初始化为完全图？

            //出去不符合条件的？

            //初始化配送中心
        }
        public static void main(String[] args) throws Exception{
            Data data = new Data();
            int stationnumber = 116;
            String path = "data/c.txt";
            process_example(path,data,stationnumber);
            System.out.println("input succesfully");
            System.out.println("cplex procedure");
            NewMip cplex = new NewMip(data);
            cplex.build_cplex();
            cplex.solve();

        }

        }

        }





