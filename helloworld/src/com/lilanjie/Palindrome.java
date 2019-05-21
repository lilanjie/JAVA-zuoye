package com.lilanjie;

public class Palindrome{
    public boolean isPalindrome(int x){
        int b ;
        int a ;
        int c = 0 ;
        int y ;
        a = x ;
        while (a>=10||a<=-10){
            b = a % 10;
            a = a / 10;
            c = c * 10 + b ;
        }
        y = c * 10 + a ;
        if (y>=0&&y==x) {
            return true;
        }
        return false;
    }

}
