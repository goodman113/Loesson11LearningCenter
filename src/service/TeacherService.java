package service;
import entity.Group;
import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static db.DataSource.*;

public class TeacherService {


    public boolean addStudentToGroup(User user,Group group){
        if (user==null||group==null)return false;
        group.getGroupStudents().add(user);
        return true;
    }
    public boolean deleteStudentFromGroup(User user,Group group){
        if (user==null||group==null)return false;
        group.getGroupStudents().remove(user);
        return true;
    }
     public Optional<Group> findGroupById(User user, String id){
         for (Group group : groups) {
             if (group.getId().equals(id)&&group.getTeacher().getId().equals(user.getId())){
                 return Optional.of(group);
             }
         }
         return Optional.empty();
     }

     public User findStudentById(String id){
         for (User student : students) {
             if (student.getId().equals(id)){
                 return student;
             }
         }
         return null;
     }
    public void showGroups(String teacherId){
        for (Group group : groups) {
            if (group.getTeacher().getId().equals(teacherId)){
                System.out.println(group);
            }

        }
    }

}
