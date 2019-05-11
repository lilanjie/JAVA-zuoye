package com.carsharing;
import ilog.concert.IloException;//处理异常
import ilog.concert.IloNumExpr; //数值表达式
import ilog.concert.IloNumVar; //为任何类型的数值变量定义API
import ilog.concert.IloNumVarType; //建模变量的类型
import ilog.cplex.IloCplex;//



public class NewMip {
    Data data;
    IloCplex cplex;
    public IloNumVar[][][] X;//二元决策变量
    public IloNumVar[][] y;//二元决策变量
    public IloNumVar[] a;
    public IloNumVar[][]S;
    //public IloNumVar[][] P;
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
    public void main(String[] args) {
        try {

            IloCplex cplex = new IloCplex();

            cplex.setOut(null);
            X = new IloNumVar[data.users][data.stationtime][data.stationtime];
            y = new IloNumVar[data.parknumber][data.stationnumber];
            a = new IloNumVar[data.stationnumber];
            S = new IloNumVar[data.stationnumber][data.stationnumber];
            // P = new IloNumVar[data.parknum][data.station];
            for (int i = 0; i < data.stationtime; i++) {
                for (int j = 0; j < data.stationtime; j++) {
                    if ( data.distance[i][j] == 0; ){
                        X[i][j] = null;
                    }
                     else{
                        for (int n = 0; n < data.users; n++) {
                            X[n][i][j] = cplex.numVar(0, 1, IloNumVarType.Int, "X" + n + "," + it + "," + jt);
                        }
                    }
                }
            }
            for (int i = 0; i < data.stationnumber; i++) {
                y[i][data.parknumber] = cplex.numVar(0, 1, IloNumVarType.Int, "y" + i + "," + data.parknumber);
            }
            //加入目标函数

            IloNumExpr obj = cplex.linearNumExpr();//
            IloNumExpr allpark = cplex.numExpr();
            IloNumExpr allvehicle = cplex.numExpr();
            IloNumExpr driveprofit = cplex.numExpr();

            for (int i = 0; i < data.stationnumber; i++) {
                allpark = cplex.sum(allpark, cplex.prod(y[i][data.parknumber], data.parknumber));
                allvehicle = cplex.sum(allvehicle, a[i][data.beginday]);
            }
            for (int n =0 ; n < data.users; n++){
                for (int i = 0; i < data.p1station; i++) {
                    for (int j = 0; j < data.p2station; j++) {
                        driveprofit = cplex.sum(driveprofit, cplex.prod(X[n][i[data.time]][j[data.time]], cplex.sum(cplex.prod(data.drivepay, data.drivetime[data.time][i][j]), (cplex.prod(-17.35, data.distance[i][j])))));
                    }
                }
            }

            obj = cplex.sum(driveprofit, cplex.prod(-data.parkcost, allpark), cplex.prod(-data.vehiclecost, allvehicle));
            cplex.addMaximize(obj);
            //加入约束（2）
            IloNumExpr expr2 = cplex.numExpr();
            IloNumExpr begindrive = cplex.numExpr();
            begindrive = cplex.sum(data.departtime, data.walktime[][]);
            expr2 = cplex.sum(begindrive,cplex.prod(-1,begindrive));
            cplex.addEq(expr2,0);
            //公式（3）
            IloNumExpr expr3 = cplex.numExpr();
            for (int n = 0; n < data.users; n++) {
                IloNumExpr arrivecar = cplex.numExpr();
                IloNumExpr leavecar = cplex.numExpr();
                double c;
                double d;
                for (int i = 0; i < data.p2station; i++) {
                    for (int j = 0; j < data.p1station; j++) {
                        arrivecar = cplex.sum(arrivecar, X[n][j[data.time]][i[data.time-c]]);
                    }
                }
                for (int i = 0; i < data.p1station; i++) {
                    for (int j = 0; j < data.p2station; j++) {
                        leavecar = cplex.sum(leavecar, X[n][i[data.time-1]][j[data.time+d]]);
                    }
                }
            }
            for( int i =0 ; i < data.p1station; i++) {
                a[i[data.time]] = cplex.sum(a[i[data.time - 1]], arrivecar, cplex.prod(-1, leavecar));
            }
            expr3 = cplex.sum(a[i[data.time]],cplex.prod(-1,a[i[data.time]]));
            cplex.addEq(expr3,0);
            //公式（4）和(5)
            IloNumExpr expr4 = cplex.numExpr();
            IloNumExpr expr5 = cplex.numExpr();
            data.time-c = cplex.sum(data.time,cplex.prod(-1,data.drivetime[data.time-c][j][i]),cplex.prod(-1,data.parktime));
            data.time+d = cplex.sum(data.time-1,data.drivetime[data.time-1][i][j],data.parktime);
            expr4 = cplex.sum(data.time-c,cplex.prod(-1,data.time-c));
            expr5 = cplex.sum(data.time+d,cplex.prod(-1,data.time+d));
            cplex.addEq(expr4,0);
            cplex.addEq(expr5,0);
            //(6)
            IloNumExpr expr6 = cplex.numExpr();
            IloNumExpr leaveitcar = cplex.numExpr();
            for (int n = 0; n < data.users; n++) {
                for (int i = 0; i < data.p1station; i++) {
                    for (int j = 0; j < data.p2station; j++) {
                       leaveitcar = cplex.sum(leaveitcar,X[n][i[data.time]][j]);
                        S[i[data.time]][j[data.time+1]] = a[i[data.time]] - leaveitcar;
                    }

                }
            }
            expr6 = cplex.sum( S[i[data.time]][j[data.time+1]],cplex.prod(-1, S[i[data.time]][j[data.time+1]]));
            cplex.addEq(expr6,0);
            //(7)
            IloNumExpr expr7 = cplex.numExpr();
               expr7 = allpark;
            cplex.addLe(a[i[data.time]],expr7);
            //(8)
            IloNumExpr expr8 = cplex.numExpr();
            for (int i = 0; i < data.stationtime; i++) {
                for (int j = 0; j < data.stationtime; j++) {
                    for (int n = 0; n < data.users; n++) {
                        expr8 = cplex.sum(expr8, X[n][i][j]);
                    }
                }
            }
            cplex.addLe(expr8,1);
            //
            IloNumExpr expr9 = cplex.numExpr();
            for (int i = 0; i < data.stationnumber; i++) {
                expr9 = cplex.sum(expr7,y[i][data.parknumber]);
            }
            expr9 = cplex.sum(expr9,y[i][data.parknumber]);
            cplex.addLe(expr9,1);
        }
        catch (IloException exc) {
            System.err.println("Concert exception '" + exc + "' caught");
        }
        }
    }




