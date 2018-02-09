package com.BaseClasses.Class;


import java.util.ArrayList;

/**
 * Created by cowlog on 18-2-10.
 * Implement student.
 */
public class Student {
    private String name;
    private ArrayList<Subject > subject;
    private double ans;

    public Student(String name) {
        this.name = name;
        subject = new ArrayList<>();
    }

    public void add(Subject sb) {
        subject.add(sb);
        ans += sb.getScore();
    }

    void print() {
        System.out.println("Name: " + name);
        for (Subject s : subject) {
            System.out.println("Subject name: " + s.getName()
                    + "\tSubject score: " + s.getScore()
                    + "\tRank: " + s.getRank());
        }
        System.out.println("Average: " + ans * 1.0 / subject.size());
    }
}
