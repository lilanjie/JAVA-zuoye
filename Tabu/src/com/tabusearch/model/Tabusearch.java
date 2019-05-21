package com.tabusearch.model;

import java.util.LinkedList;
import java.util.List;

public class Tabusearch {
    private LinkedList<Bag> queue = new LinkedList<>();

    private BagImprover bagImprover;

    private Bag currentBag;

    private Bag bestBag;

    private List<Good> goods;

    private Integer queueSize;

    public TabuSearch(Bag bag, Integer queueSize, DataLoader dataLoader, BagInitializer bagInitializer, BagImprover bagImprover) {
        this.bagImprover = bagImprover;
        this.goods = dataLoader.loadData();
        this.currentBag = bagInitializer.initialize(goods, bag);
        this.bestBag = currentBag;
        this.queueSize = queueSize;
    }

    public Bag solve(Integer time) {
        for(int i = 0; i < time; i++){
            List<Bag> improveBags = bagImprover.improve(goods, currentBag);
            for (Bag improveBag : improveBags) {
                if (queue.contains(improveBag)){
                    continue;
                }
                queue.addLast(improveBag);
                if (bestBag.getCurrentValue() < improveBag.getCurrentValue()){
                    bestBag = improveBag;
                }
                if (queue.size() > queueSize) {
                    queue.removeFirst();
                }
                break;
            }
        }
        return bestBag;
    }
}
