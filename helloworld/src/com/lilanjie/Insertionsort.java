package com.lilanjie;

public class Insertionsort {
    public  static int[] insertionsort(int[] a){
        int i ;
        int key ;
        for(int j = 1 ; j < a.length ; j++){
            key = a[j] ;

            i = j - 1 ;
            while (i >= 0 && a[i] > key){
                a[i + 1] = a[i] ;
                i = i - 1 ;
            }
            a [ i + 1 ] = key;
        }
        return a;

    }
}
