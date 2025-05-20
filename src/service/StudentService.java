package service;

import entity.User;

import static db.DataSource.students;

public class StudentService {

    public static void showStudents(){
        for (User student : students) {
            System.out.println(student);
        }
    }
    public static User findStudentById(String id){
        for (User student : students) {
            if (student.getId().equals(id))return student;
        }
       return null;
    }
}

