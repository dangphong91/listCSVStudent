package com.student.services;

import com.student.data.*;
import com.student.model.*;

import java.io.*;
import java.util.*;

public class StudentManager {
    private FileCSV fileCSV;
    private ArrayList<Student> list;

    public StudentManager(File file) {
        this.fileCSV = new FileCSV(file);
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

    public void menu() {
        System.out.println("Menu:\n" +
                "1.Read File\n" +
                "2.Add Student\n" +
                "3.Edit Student\n" +
                "4.Remove Student\n" +
                "5.Import Score\n" +
                "6.Sort Student\n" +
                "X.Exit");
    }
    public void run() {
        Scanner sc = new Scanner(System.in);
        String choice;
        String name;
        int id;
        int age;
        String gender;
        while (true) {
            menu();
            System.out.println("Choice:");
            choice = sc.nextLine();
            switch (choice) {
                case "1" :
                    System.out.println("Students:");
                    try {
                        readList();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "2" :
                    System.out.println("Add Student:");
                    System.out.println("Name:");
                    name = sc.nextLine();
                    System.out.println("Id:");
                    id = Integer.parseInt(sc.nextLine());
                    System.out.println("Age:");
                    age = Integer.parseInt(sc.nextLine());
                    System.out.println("Gender:");
                    gender = sc.nextLine();
                    Student st = new Student(name,id,age,gender);
                    addStudent(st);
                    break;
                case "3" :
                    System.out.println("Edit Student:");
                    System.out.println("Name:");
                    name = sc.nextLine();
                    System.out.println("Id:");
                    id = Integer.parseInt(sc.nextLine());
                    System.out.println("Age:");
                    age = Integer.parseInt(sc.nextLine());
                    System.out.println("Gender:");
                    gender = sc.nextLine();
                    editStudent(name,id,age,gender);
                    break;
                case "4" :
                    System.out.println("Remove Student:");
                    System.out.println("Id:");
                    id = Integer.parseInt(sc.nextLine());
                    removeStudent(id);
                    break;
                case "5" :
                    break;
                case "6" :
                    System.out.println("Sort Student:");
                    sortStudent();
                    break;
                case "X" :
                    System.exit(0);
                default:
                    System.out.println("Not Now ...");
            }
        }
    }
}
