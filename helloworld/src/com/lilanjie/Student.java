package com.lilanjie;


public class Student {

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;


    }

    private String name;
    private Integer score;

    public Boolean isScoreGreaterThan(Student that) {
        if (this.score > that.getScore()) {
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

    public String getFirstName() {
        String firstName = name.substring(0, 1);
        return firstName;
    }

    public void rename(String newName) {
        this.name = getFirstName() + newName;
    }


    public void print() {

        System.out.println(this.getName() + "的分数是： " + this.getScore());
//为什么要用this?我好像知道得用它但又不知道为啥。
    }
}