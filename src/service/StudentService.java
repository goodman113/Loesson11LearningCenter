package service;

import entity.User;

import static db.DataSource.students;

public class StudentService {

    public void showStudents(){
        for (User student : students) {
            System.out.println(student);
        }
    }
}
