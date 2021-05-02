package com.student.model;

public class Student implements Comparable<Student> {
    String name;
    int id;
    int age;
    String gender;
    int score1;
    int score2;
    int score3;
    int score4;
    double average;

    public Student(String name, int code, int age, String gender) {
        this.name = name;
        this.id = code;
        this.age = age;
        this.gender = gender;
        this.score1 = 0;
        this.score2 = 0;
        this.score3 = 0;
        this.score4 = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public void setScore3(int score3) {
        this.score3 = score3;
    }

    public void setScore4(int score4) {
        this.score4 = score4;
    }

    public double getAverage() {
        this.average  = (double) (score1 + score2 + score3 * 2 + score4 * 3)/ 7;
        return average;
    }

    @Override
    public String toString() {
        return name + "," + id + "," + age + "," + gender + "," + score1 + "," + score2 + "," + score3 + "," + score4 + "," + getAverage() + "\n";
    }

    @Override
    public int compareTo(Student student) {
        return this.getName().compareTo(student.getName());
    }
}
