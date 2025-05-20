package service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static db.DataSource.*;

public class TeacherService {





     public  static User findStudentById(String id){
         for (Student student : students) {
             if (student.getId().equals(id)){
                 return student;
             }
         }
         return null;
     }

}
