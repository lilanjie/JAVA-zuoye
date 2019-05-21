package com.jinjisousuo.model;

import java.util.HashSet;
import java.util.Set;

public class Bag {

    private Integer currentWeight;

    private Integer currentValue;

    private Integer totalWeight;

    private Set<Good> goods = new HashSet<>();

    public Bag(int totalWeight){
        this.totalWeight = totalWeight;
        this.currentValue= 0 ;
        this.currentWeight = 0;
    }

    public Bag(Bag bag){
        this.totalWeight = bag.getTotalWeight();
        this.currentValue= bag.getCurrentValue() ;
        this.currentWeight = bag.getCurrentWeight();
        this.goods.addAll(bag.goods);
    }

    public boolean canAdd(Good good){
        return !goods.contains(good) && currentWeight + good.getWeight() < totalWeight;
    }

    public boolean contains(Good good){
        return goods.contains(good);
    }

    public void addGood(Good good){
        goods.add(good);
        currentValue += good.getValue();
        currentWeight += good.getWeight();
    }

    public void removeGood(Good good){
        goods.remove(good);
        currentValue -= good.getValue();
        currentWeight -= good.getWeight();
    }

    public Set<Good> getGoods() {
        return goods;
    }

    public void setGoods(Set<Good> goods) {
        this.goods = goods;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if (!(o instanceof Bag)){
            return false;
        }
        Bag bag = (Bag) o;
        if(!currentWeight.equals(bag.getCurrentValue()) && currentValue.equals(bag.getCurrentValue())
                && totalWeight.equals(bag.totalWeight)){
            return false;
        }
        if (goods.size() != bag.goods.size()){
            return false;
        }
        for (Good good : goods) {
            if (!bag.goods.contains(good)){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result += currentValue;
        result *= 31;
        result += currentWeight;
        result *= 31;
        result += totalWeight;
        return result;
    }
}
