package service;
import entity.Group;
import entity.User;

import java.util.Optional;

import static db.DataSource.*;

public class TeacherService {

    public void addStudentToGroup(User user){

    }
     public Optional<Group> findGroupById(User user, String id){
         for (Group group : groups) {
             if (group.getId().equals(id)&&group.getTeacher().getId().equals(user.getId())){
                 return Optional.of(group);
             }
         }
         return Optional.empty();
     }


}
