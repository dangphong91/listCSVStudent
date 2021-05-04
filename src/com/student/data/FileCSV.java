package com.student.data;

import com.student.model.Student;

import java.io.*;
import java.util.*;

public class FileCSV {
    private File file;
    private  ArrayList<Student> list;
    private final String HEADER = "Name,Code,Age,Gender,Score1,Score2,Score3,Score4,Average";

    public FileCSV(File file) {
        this.file = file;
    }

    public ArrayList<Student> getList() {
        return list;
    }

    public ArrayList<Student> read(){
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            list = new ArrayList<Student>();
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals(HEADER)) {
                    continue;
                }
                String[] st = line.split(",");
                Student student = new Student(st[0], Integer.parseInt(st[1]), Integer.parseInt(st[2]), st[3]);
                student.setScore1(Integer.parseInt(st[4]));
                student.setScore2(Integer.parseInt(st[5]));
                student.setScore3(Integer.parseInt(st[6]));
                student.setScore4(Integer.parseInt(st[7]));
                System.out.print(student.toString());
                list.add(student);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void write() {
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(HEADER);
            bw.append("\n");
            for (Student st :
                    list) {
                bw.append(st.toString());
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
