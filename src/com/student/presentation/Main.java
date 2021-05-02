package com.student.presentation;

import com.student.model.Student;
import com.student.services.StudentManager;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("D:\\bai tap\\sv.csv");
        StudentManager list1 = new StudentManager();
        list1.setFileCSV(file1);
        try {
            list1.readList();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Student tin = new Student("Tin",1515, 25, "Nam");
//        list1.addStudent(tin);
//        list1.editStudent("Duong", 1414, 25, "Bede");
//        list1.removeStudent(1515);
        list1.importScore1("Phong", 10);
        list1.importScore2("Phong", 9);
        list1.importScore3("Phong", 9);
        list1.importScore4("Phong", 10);
        list1.sortStudent();
        try {
            list1.readList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
