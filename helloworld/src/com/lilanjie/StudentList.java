package com.lilanjie;


public class StudentList {
    private Integer size = 0;
    private Integer length = 16;
    private Student[] students;
    public StudentList() {

        students=new Student[length];
    }
    public void add(int index,Student student){
        if(index>size){
            throw new RuntimeException("索引越界");
        }
        if(size>=length){
            length*=2;
            Student[] newStudents=new Student[length];
            System.arraycopy(students, 0, newStudents,0,size);
            students=newStudents;
        }
        System.arraycopy(students, index, students, index + 1, size - index);
        students[index]=student;
        size++;
    }
    public void remove(int index){
        System.arraycopy(students, index+1, students, index, size - index-1);
        size--;
    }
    public   Student getStudent(int index){
        return students[index];
    }
}

