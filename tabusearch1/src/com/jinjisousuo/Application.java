package com.jinjisousuo;

import com.jinjisousuo.bagImprover.RandomBagImprover;
import com.jinjisousuo.bagInitializer.FrontToBackBagInitializer;
import com.jinjisousuo.dataLoader.FixDataLoader;
import com.jinjisousuo.model.Bag;
import com.jinjisousuo.tabuSearcch.TabuSearch;

public class Application {

    public static void main(String[] args) {
        TabuSearch tabuSearch = new TabuSearch(new Bag(40), 10, new FixDataLoader()
                , new FrontToBackBagInitializer(), new RandomBagImprover());
        Bag solve = tabuSearch.solve(100);
        System.out.println(solve.getCurrentValue());
        solve.getGoods().forEach(good -> {
            System.out.println(good.getWeight() + " " + good.getValue());
        });
    }
}
