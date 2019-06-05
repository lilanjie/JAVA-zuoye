package com.carsharing.location;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Stationgenerator {

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


    public static Station[] readFromFile(String name) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(name));
            Station[] stations = (Station[]) objectInputStream.readObject();
            objectInputStream.close();
            return stations;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
