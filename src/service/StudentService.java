package service;

import entity.Group;
import entity.Student;
import entity.User;

import static db.DataSource.*;

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

    public static void myAttendance() {
//        Attendance attendance = new Attendance();
//        System.out.println(attendance.getAttendedStudents());

        for (Group group : groups) {
            if (group.getGroupStudents().equals(currentUser)){
                System.out.println(group);
            }
        }
    }

    public static void myMarks() {
        Student student = new Student();
        for (int i = 0; i < students.size(); i++) {
            System.out.println(student.getMarks());
        }
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

