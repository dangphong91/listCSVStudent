package com.student.services;

import com.student.data.*;
import com.student.model.*;

import java.io.*;
import java.util.*;

public class StudentManager {
    private final FileCSV fileCSV;
    private ArrayList<Student> list;

    public StudentManager(File file) {
        this.fileCSV = new FileCSV(file);
    }

    public int find(int id) {
        list = fileCSV.getList();
        for (Student st:
             list) {
            if (st.getCode() == id) {
                return list.indexOf(st);
            }
        }
        return -1;
    }

    public void addStudent(Student student) {
        if (find(student.getCode()) == -1) {
            list.add(student);
            fileCSV.write();
            System.out.println("Add success.");
        }
        else {
            System.out.println("Can't add. Id exists.");
        }
    }

    public void editStudent(String name, int id, int age, String gender) {
        int i = find(id);
        if (i != -1) {
            list.get(i).setName(name);
            list.get(i).setAge(age);
            list.get(i).setGender(gender);
            fileCSV.write();
            System.out.println("Edit success.");
        }
        else {
            System.out.println("Can't edit. Id not exists.");
        }
    }

    public void importScore1(int id, int score) {
        int i = find(id);
        if (i != -1) {
            list.get(i).setScore1(score);
            fileCSV.write();
            System.out.println("Import success.");
        }
        else {
            System.out.println("Can't import. Id not exists.");
        }
    }

    public void importScore2(int id, int score) {
        int i = find(id);
        if (i != -1) {
            list.get(i).setScore2(score);
            fileCSV.write();
            System.out.println("Import success.");
        }
        else {
            System.out.println("Can't import. Id not exists.");
        }
    }

    public void importScore3(int id, int score) {
        int i = find(id);
        if (i != -1) {
            list.get(i).setScore3(score);
            fileCSV.write();
            System.out.println("Import success.");
        }
        else {
            System.out.println("Can't import. Id not exists.");
        }
    }

    public void importScore4(int id, int score) {
        int i = find(id);
        if (i != -1) {
            list.get(i).setScore4(score);
            fileCSV.write();
            System.out.println("Import success.");
        }
        else {
            System.out.println("Can't import. Id not exists.");
        }
    }

    public void removeStudent(int id) {
        int i = find(id);
        if (i != -1) {
            list.remove(i);
            fileCSV.write();
            System.out.println("Remove success.");
        }
        else {
            System.out.println("Can't remove. Id not exists.");
        }
    }

    public void sortStudent() {
        list = fileCSV.getList();
        AverageComparator averageComparator = new AverageComparator();
        list.sort(averageComparator);
        fileCSV.write();
        System.out.println("Sort success.");
    }

    public void readList() {
        fileCSV.read();
    }

    public void menu() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
        for (int i = 0; i < 148; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("|%4s%s%5s|"," ","1.Read File"," ");
        System.out.printf("%3s%s%4s|"," ","2.Add Student"," ");
        System.out.printf("%3s%s%3s|"," ","3.Edit Student"," ");
        System.out.printf("%2s%s%2s|"," ","4.Remove Student"," ");
        System.out.printf("%3s%s%3s|"," ","5.Import Score"," ");
        System.out.printf("%3s%s%3s|"," ","6.Sort Student"," ");
        System.out.printf("%3s%s%4s|"," ","X.Exit System"," ");
        System.out.println();
        for (int i = 0; i < 148; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    public void run() {
        try (Scanner sc = new Scanner(System.in)) {
            String choice;
            String name;
            int id;
            int age;
            String gender;
            int score1, score2, score3, score4;
            String yesNo;
            while (true) {
                menu();
                choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        for (int i = 0; i < 148; i++) {
                            System.out.print("-");
                        }
                        System.out.println();
                        System.out.printf("|%5s%s%5s|"," ","Name"," ");
                        System.out.printf("%6s%s%6s|"," ","Id"," ");
                        System.out.printf("%3s%s%4s|"," ","Age"," ");
                        System.out.printf("%3s%s%3s|"," ","Gender"," ");
                        System.out.printf("%3s%s%4s|"," ","Score 1"," ");
                        System.out.printf("%3s%s%4s|"," ","Score 2"," ");
                        System.out.printf("%3s%s%4s|"," ","Score 3"," ");
                        System.out.printf("%3s%s%4s|"," ","Score 4"," ");
                        System.out.printf("%5s%s%5s|"," ","Average"," ");
                        System.out.printf("%2s%s%2s|"," ","Classified"," ");
                        System.out.println();
                        for (int i = 0; i < 148; i++) {
                            System.out.print("-");
                        }
                        System.out.println();
                        readList();
                        for (int i = 0; i < 148; i++) {
                            System.out.print("-");
                        }
                        System.out.println();
                        System.out.println("Press the enter key to return menu");
                        sc.nextLine();
                        break;
                    case "2":
                        System.out.println("Add Student:");
                        System.out.println("Name:");
                        name = sc.nextLine();
                        System.out.println("Id:");
                        id = Integer.parseInt(sc.nextLine());
                        System.out.println("Age:");
                        age = Integer.parseInt(sc.nextLine());
                        System.out.println("Gender:");
                        gender = sc.nextLine();
                        Student st = new Student(name, id, age, gender);
                        addStudent(st);
                        System.out.println("Press the enter key to return menu");
                        sc.nextLine();
                        break;
                    case "3":
                        System.out.println("Edit Student:");
                        System.out.println("Name:");
                        name = sc.nextLine();
                        System.out.println("Id:");
                        id = Integer.parseInt(sc.nextLine());
                        System.out.println("Age:");
                        age = Integer.parseInt(sc.nextLine());
                        System.out.println("Gender:");
                        gender = sc.nextLine();
                        editStudent(name, id, age, gender);
                        System.out.println("Press the enter key to return menu");
                        sc.nextLine();
                        break;
                    case "4":
                        System.out.println("Remove Student:");
                        System.out.println("Id:");
                        id = Integer.parseInt(sc.nextLine());
                        removeStudent(id);
                        System.out.println("Press the enter key to return menu");
                        sc.nextLine();
                        break;
                    case "5":
                        System.out.println("Import Score:");
                        System.out.println("Id:");
                        id = Integer.parseInt(sc.nextLine());
                        if (find(id) != -1) {
                            System.out.println("Score 1:");
                            score1 = Integer.parseInt(sc.nextLine());
                            importScore1(id, score1);
                            System.out.println("Next Import ? Y/N");
                            editScore:
                            while (true) {
                                yesNo = sc.nextLine();
                                switch (yesNo) {
                                    case "Y":
                                        System.out.println("Score 2:");
                                        score2 = Integer.parseInt(sc.nextLine());
                                        importScore2(id, score2);
                                        System.out.println("Next Import ? Y/N");
                                        while (true) {
                                            yesNo = sc.nextLine();
                                            switch (yesNo) {
                                                case "Y":
                                                    System.out.println("Score 3:");
                                                    score3 = Integer.parseInt(sc.nextLine());
                                                    importScore3(id, score3);
                                                    System.out.println("Next Import ? Y/N");
                                                    while (true) {
                                                        yesNo = sc.nextLine();
                                                        switch (yesNo) {
                                                            case "Y":
                                                                System.out.println("Score 4:");
                                                                score4 = Integer.parseInt(sc.nextLine());
                                                                importScore4(id, score4);
                                                                break editScore;
                                                            case "N":
                                                                break editScore;
                                                            default:
                                                                System.out.println("Y/N");
                                                        }
                                                    }
                                                case "N":
                                                    break editScore;
                                                default:
                                                    System.out.println("Y/N");
                                            }
                                        }
                                    case "N":
                                        break editScore;
                                    default:
                                        System.out.println("Y/N");
                                }
                            }
                        } else {
                            System.out.println("Id not exists.");
                        }
                        System.out.println("Press the enter key to return menu");
                        sc.nextLine();
                        break;
                    case "6":
                        System.out.println("Sort Student:");
                        sortStudent();
                        System.out.println("Press the enter key to return menu");
                        sc.nextLine();
                        break;
                    case "X":
                        System.exit(0);
                    default:
                        System.out.println("Not now ... Press the enter key to return menu");
                        sc.nextLine();
                }
            }
        }
    }
}
