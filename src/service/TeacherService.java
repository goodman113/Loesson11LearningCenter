package service;
import entity.Group;
import entity.Student;
import entity.User;

import java.util.Optional;

import static db.DataSource.*;

public class TeacherService {


    public void addStudentToGroup(User user,Group group){
        if (user==null||group==null)return;
        group.getGroupStudents().add(user);
    }
    public void deleteStudentFromGroup(User user,Group group){
        if (user==null||group==null)return;
        group.getGroupStudents().remove(user);
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
         for (Student student : students) {
             if (student.getId().equals(id)){
                 return student;
             }
         }
         return null;
     }


}
