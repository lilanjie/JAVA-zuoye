package com.jinjisousuo.bagImprover;

import com.jinjisousuo.model.Bag;
import com.jinjisousuo.model.Good;

import java.util.*;

public class RandomBagImprover implements BagImprover {

    private Random random = new Random();

    @Override
    public List<Bag> improve(List<Good> goods, Bag bag) {
        List<Bag> bags = new ArrayList<>();
        while (bags.size() < 10){
            Bag newBag = new Bag(bag);
            for(int i=0; i < 3; i++) {
                int randomIndex = random.nextInt(goods.size());
                if (newBag.contains(goods.get(randomIndex))) {
                    newBag.removeGood(goods.get(randomIndex));
                }
                else {
                    if (newBag.canAdd(goods.get(randomIndex))) {
                        newBag.addGood(goods.get(randomIndex));
                    }
                }
            }
            bags.add(newBag);
        }
        bags.sort(new Comparator<Bag>() {
            @Override
            public int compare(Bag o1, Bag o2) {
                return Integer.compare(o2.getCurrentValue(),o1.getCurrentValue());
            }
        });
        return bags;
    }
}
