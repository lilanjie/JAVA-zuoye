package com.carsharing.location;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Usergenerator {
    User user;

    public static User RandomCreate(){
        List<Point> list = new ArrayList<Point>();
        int Usernm = 100;
        for (int n =0; n <Usernm; n++){
            User users = User.RandomCreate();
            if(users.isEnoughFar()){
               list.add(users);
            }
        }
        return new User();
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
        User user = User.RandomCreate());
        user.print();
        Usergenerator.writeToFile("user");
    }

}
