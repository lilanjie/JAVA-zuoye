package com.jinjisousuo;
//*建一个类，物品

public class Goods {
    public Goods(Integer weight,Integer value){
        this.weight = weight;
        this.value = value;
    }
    private Integer weight;
    private Integer value;

    public Integer getWeight(){
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
