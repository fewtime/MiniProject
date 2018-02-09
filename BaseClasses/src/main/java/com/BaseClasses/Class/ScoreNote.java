package com.BaseClasses.Class;

import java.util.ArrayList;

/**
 * Created by cowlog on 18-2-10.
 * 记录一个班级的学生
 * 创建一个Student类，记录他们的名字、平均分和考试分数 和他们的成绩等级。
 * 根据学生的测验和作业的分数计算出平均分和成绩等级。
 * TODO: 复杂一点可以将数据画在贝尔曲线上。
 */
public class ScoreNote {
    private ArrayList<Student> list;
    public ScoreNote() {
        list = new ArrayList<>();
    }
    public void list() {
        for (Student s : list) {
            s.print();
        }
    }

    public void add(Student s) {
        list.add(s);
    }
}
