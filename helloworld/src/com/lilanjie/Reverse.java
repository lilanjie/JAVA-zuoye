package com.lilanjie;

public class Reverse {
    public int reverse(int x) {
        int b =0 ;
        int a ;
        int y ;
        while (x>=10||x<=-10){
            a = x % 10;
            x = x / 10;
            b = b * 10 + a ;
        }
        y = b * 10 + x ;

        if ((y-x)/10!=b) {
            return 0;
        }
        return y ;
    }

}
