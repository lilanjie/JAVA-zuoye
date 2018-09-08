package com.lilanjie;

public class Student {

    public Student (String name,Integer score){
        this.name=name;
        this.score=score;


    }

    private String name;
    private Integer score;

    public Boolean isScoreGreaterThan(Student that){
        if (this.score>that.getScore()){
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
