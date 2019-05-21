package com.lilanjie;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public int romanToInt(String s) {
            Map<Character,Integer> map=new HashMap<>();
            map.put('I',1);
            map.put('V',5);
            map.put('X',10);
            map.put('L',50);
            map.put('C',100);
            map.put('D',500);
            map.put('M',1000);
            int y = 0;
            int x = 0;
            for (int j = s.length()-1; j >= 0; j--) {
                    char item = s.charAt(j);
                    if (map.get(item)>=x){
                            y = y + map.get(item);
                        }
                    else {
                            y = y - map.get(item);
                    }
                    x = map.get(item);


            }




        return y;
    }
}
