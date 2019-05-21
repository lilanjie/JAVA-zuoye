package com.jinjisousuo.model;
//*建一个类，物品

public class Good {
    public Good(Integer weight, Integer value){
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


    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if (!(o instanceof Good)){
            return false;
        }
        Good good = (Good) o;
        return weight.equals(good.getWeight()) && value.equals(good.getValue());
    }

    @Override
    public int hashCode() {
        return weight*255+value;
    }
}
