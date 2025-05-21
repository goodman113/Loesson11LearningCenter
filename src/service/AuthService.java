package service;
import entity.User;
import entity.enums.Role;

import static db.DataSource.*;
public class AuthService {
    public static void service() {
        while (true) {
            System.out.println("enter email");
            String email = strScanner.nextLine();
            System.out.println("enter password");
            String password = strScanner.nextLine();
            if (email.equals("admin") && password.equals("admin")) {
                AdminService adminService = new AdminService();
                adminService.service();
            }
            for (User user : users) {
                if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    if (user.getRole().equals(Role.TEACHER)){
                        currentUser = user;
                        System.out.println(user);
                        System.out.println(currentUser);
                        TeacherService.service();
                }
                }
            }
        }
    }
}