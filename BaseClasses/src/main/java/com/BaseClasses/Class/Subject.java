package com.BaseClasses.Class;

/**
 * Created by cowlog on 18-2-10.
 * Implement subject.
 */
public class Subject {
    private String name;
    private double score;
    private String rank;

    public Subject(String name, double score) {
        this.name = name;
        this.score = score;
        if (score == 100) {
            rank = "A++";
        } else if (90 <= score && score < 100) {
            rank = "A";
        } else if (80 <= score && score < 90) {
        rank = "B";
        } else if (70 <= score && score < 80) {
            rank = "C";
        } else if (60 <= score && score < 70) {
            rank = "D";
        } else if (score < 60) {
            rank = "E";
        }
    }

    String getName() {
        return name;
    }

    double getScore() {
        return score;
    }

    String getRank() {
        return rank;
    }
}
