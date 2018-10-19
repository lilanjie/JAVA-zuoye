package com.lilanjie;

import com.lilanjie.Student;

public class StudentLinkedList {
    transient int size = 0;
    transient Node<Student> first;
    transient Node<Student> last;

    private static class Node<Student> {
        Student item;
        Node<Student> next;
        Node<Student> prev;

        Node(Node<Student> prev, Student student, Node<Student> next) {
            this.item = student;
            this.next = next;
            this.prev = prev;
        }
    }
    public void add(int index,Student student) {
      // checkPositionIndex(index);
       if (index==size)
        linkLast(student);
       else
           linkBefore(student,node(index));
    }

    void linkLast(Student student) {
       final Node<Student> l = last;
        final Node<Student> newNode = new Node<>(l, student, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        //modCount就是集合修改的次数
    }
    Node<Student> node(int index){
        if (index<(size>>1)){
            Node<Student> x = first;
            for (int i = 0;i< index; i++)
                x = x.next;
        }
        else {
            Node<Student> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
        return ;
    }
    void linkBefore(Student student,Node<Student> succ){
        final Node<Student> pred = succ.prev;
        final Node<Student> newNode = new Node<>(pred,student,succ);
        succ.prev = newNode;
        if (pred ==null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }
    public Student remove(int index){
        ///checkStudentIndex(index);
        return unlink(node(index));
    }
    Student unlink(Node<Student> x ){
        final Student student = x.item;
        final Node<Student> next = x.next;
        final Node<Student> prev = x.prev;

        if (prev == null){
            first = next;
        }
        else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null){
            last = prev;
        }
        else {
            next.prev = prev;
            x.next = null;
        }
        x.item = null;
        size--;
        return
    }
    public Student get(int index){
        //checkStudentIndex(index);
        return node(index).item;
    }
}



