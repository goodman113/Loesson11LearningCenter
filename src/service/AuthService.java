package service;
import entity.User;
import entity.enums.Role;

import static db.DataSource.*;

public class AuthService {
    public static void service(){
        while (true) {
            System.out.println("""
                    0 exit;
                    1 sign in;
                    """);
            switch (scanner.nextInt()){
                case 0->{
                    return;
                }
                case 1->{
                    signIn();
                }
            }
        }
    }
    private static void signIn() {
        System.out.println("enter email");
        String email=strScanner.nextLine();
        System.out.println("enter password");
        String password=strScanner.nextLine();
        for (User user : users) {
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                if(user.getRole()== Role.ADMIN){
                    currentUser=user;
                    new AdminService().service();
                }
                if(user.getRole()== Role.STUDENT){
                    currentUser=user;
                   StudentService.service();
                }
                if(user.getRole()== Role.TEACHER){
                    currentUser=user;
                   TeacherService.service();
                }

            }
        }
    }
}
