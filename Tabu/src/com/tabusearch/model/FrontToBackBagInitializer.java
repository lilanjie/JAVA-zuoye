package com.tabusearch.model;

import java.util.List;

public class FrontToBackBagInitializer implements BagInitializer {
    @Override
    public Bag initialize(List<Good> goods, Bag bag) {
        for (Good good : goods) {
            if (bag.canAdd(good)){
                bag.addGood(good);
            }
        }
        return bag;
    }
}
