package com.carsharing.location;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Usergenerator {

    public static User[] RandomCreate(){
        User[] users = new User[100];
        //java.util.List<User> userList = new ArrayList<>();
        int Usernum = 100;
        for (int n =0; n <Usernum; n++){
             User user = User.RandomCreate();
            if(user.isEnoughFar()){
                users[n] = user;
              //userList.add(users);
                System.out.println("用户原点是： " + user.getOrign()+"终点是："+user.getDestination()+" 出发时间是："+user.getDeparttime());

            }
        }
        return users;
    }

    public  static void writeToFile(String name) {
        try {
            FileOutputStream fs = new FileOutputStream(name);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            User[] users = new User[100];
            os.writeObject(users);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User readFromFile(String name) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(name));
            User user = (User) objectInputStream.readObject();
            objectInputStream.close();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Usergenerator.RandomCreate();
        Usergenerator.writeToFile("user");
    }

}
