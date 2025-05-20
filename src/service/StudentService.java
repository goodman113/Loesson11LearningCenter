package service;

import entity.Student;
import entity.User;

import static db.DataSource.*;
import static db.DataSource.students;

public class StudentService {
public static void service(){

    while (true) {
        System.out.println("""
                    0 exit
                    1 My marks
                    2 My attendance
                    """);


        switch (strScanner.nextLine()) {
            case "0" -> {
                return;
            }
            case "1" -> myMarks();
            case "2" -> myAttendance();
        }
    }

}

    private static void myAttendance() {

    }

    private static void myMarks() {
    }

    public static void showStudents(){
        for (User student : students) {
            System.out.println(student);
        }
    }
    public static Student findStudentById(String id){
        for (Student student : students) {
            if (student.getId().equals(id))return student;
        }
       return null;
    }
}

