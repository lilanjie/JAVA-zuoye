package com.jinjisousuo.dataLoader;

import com.jinjisousuo.model.Good;

import java.util.ArrayList;
import java.util.List;

public class FixDataLoader implements DataLoader {

    @Override
    public List<Good> loadData() {
        Good good1 = new Good(5,12);
        Good good2 = new Good(4,3);
        Good good3 = new Good(7,10);
        Good good4 = new Good(2,3);
        Good good5 = new Good(6,6);
        Good good6 = new Good(3,7);
        Good good7 = new Good(8,9);
        Good good8 = new Good(5,6);
        Good good9 = new Good(8,12);
        Good good10 = new Good(4,2);
        ArrayList<Good> goods = new ArrayList<>();
        goods.add(good1);
        goods.add(good2);
        goods.add(good3);
        goods.add(good4);
        goods.add(good5);
        goods.add(good6);
        goods.add(good7);
        goods.add(good8);
        goods.add(good9);
        goods.add(good10);
        return goods;
    }
}
