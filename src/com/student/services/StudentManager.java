package com.student.services;

import com.student.data.FileCSV;
import com.student.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class StudentManager {
    private FileCSV fileCSV;
    private ArrayList<Student> list;

    public StudentManager() {
    }

    public void setFileCSV(File file) {
        fileCSV = new FileCSV(file);
    }

    public void addStudent(Student student) {
        list = fileCSV.getList();
        list.add(student);
        fileCSV.write();
        System.out.println("Add success.");
    }

    public void editStudent(String name, int id, int age, String gender) {
        list = fileCSV.getList();
        for (Student st:
             list) {
            if (st.getName().equals(name)) {
                st.setId(id);
                st.setAge(age);
                st.setGender(gender);
                fileCSV.write();
                System.out.println("Edit success.");
            }
        }
    }

    public void importScore1(String name, int score) {
        list = fileCSV.getList();
        for (Student st:
                list) {
            if (st.getName().equals(name)) {
                st.setScore1(score);
                fileCSV.write();
                System.out.println("Import success.");
            }
        }
    }

    public void importScore2(String name, int score) {
        list = fileCSV.getList();
        for (Student st:
                list) {
            if (st.getName().equals(name)) {
                st.setScore2(score);
                fileCSV.write();
                System.out.println("Import success.");
            }
        }
    }

    public void importScore3(String name, int score) {
        list = fileCSV.getList();
        for (Student st:
                list) {
            if (st.getName().equals(name)) {
                st.setScore3(score);
                fileCSV.write();
                System.out.println("Import success.");
            }
        }
    }

    public void importScore4(String name, int score) {
        list = fileCSV.getList();
        for (Student st:
                list) {
            if (st.getName().equals(name)) {
                st.setScore4(score);
                fileCSV.write();
                System.out.println("Import success.");
            }
        }
    }

    public boolean removeStudent(int id) {
        list = fileCSV.getList();
        for (Student st:
             list) {
            if (st.getId() == id) {
                list.remove(st);
                fileCSV.write();
                System.out.println("Remove success.");
                return true;
            }
        }
        return false;
    }

    public void sortStudent() {
        list = fileCSV.getList();
        AverageComparator averageComparator = new AverageComparator();
        Collections.sort(list,averageComparator);
        fileCSV.write();
        System.out.println("Sort success.");
    }

    public ArrayList<Student> readList() throws IOException {
        return fileCSV.read();
    }
}
