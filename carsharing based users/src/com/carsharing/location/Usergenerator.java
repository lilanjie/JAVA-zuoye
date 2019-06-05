package com.carsharing.location;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Usergenerator {

    public static User[] RandomCreate(){
        //java.util.List<User> userList = new ArrayList<>();
        User[] users = new User[5];
       // int m = 0;
        for (int n =0; n <users.length; n++){
             User user = User.RandomCreate();
            //if(user.isEnoughFar()){
                users[n] = user;
                //userList.add(user);
                //m++;
                System.out.println("用户原点是： " + users[n].getOrign()+" 终点是："+users[n].getDestination()+" 出发时间是："+users[n].getDeparttime());
            //}
        }

        return users;
    }

    public  static void writeToFile(String name) {
        try {
            FileOutputStream fs = new FileOutputStream(name);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            User[] users = new User[5];
            os.writeObject(users);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User[] readFromFile(String name) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(name));
            User[] users = (User[]) objectInputStream.readObject();
            objectInputStream.close();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /*public static void main(String[] args) {
        Usergenerator.RandomCreate();
        //Usergenerator.writeToFile("user2");
    }*/

}
