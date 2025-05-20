package service;
import entity.User;
import entity.enums.Role;

import static db.DataSource.*;
import static db.Storage.users;

public class AuthService {
    public void service(){
        System.out.println("enter email");
        String email=strScanner.nextLine();
        System.out.println("enter password");
        String password=strScanner.nextLine();
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                if (user.getRole().equals(Role.ADMIN)) {
                    new AdminService().service();
                }
                if (user.getRole().equals(Role.STUDENT)) {
                    new StudentService().service();
                }
                if(user.getRole().equals(Role.TEACHER)){
                    new TeacherService().service();
                }
            }
        }

    }
}
