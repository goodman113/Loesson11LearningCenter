package service;
import entity.User;
import entity.enums.Role;
import  ui.*;
import static db.DataSource.*;
public class AuthService {
    public void service(){
        System.out.println("enter email");
        String email=strScanner.nextLine();
        System.out.println("enter password");
        String password=strScanner.nextLine();
        for (User user : students) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                if (user.getRole().equals(Role.ADMIN)) {
                    new AdminService().service();
                }
                if (user.getRole().equals(Role.STUDENT)) {
                    StudentUi studentUi = new StudentUi();
                    studentUi.studentUi(user);
                }
                if(user.getRole().equals(Role.TEACHER)){
                    TeacherUi teacherUi = new TeacherUi();
                    teacherUi.teacherUi(user);
                }
            }
        }

    }
}
