import db.DataSource;
import entity.User;
import entity.enums.Role;
import service.AuthService;
import ui.AdminUi;
import ui.StudentUi;
import ui.TeacherUi;

import static db.DataSource.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static AuthService authService = new AuthService();

    public static void main(String[] args) {
        boolean isExisted =false;
        while (!isExisted) {
            System.out.print("""
                    1 Sign up
                    2 Sign in
                    \s
                    0 Exit
                    >>>>\s""");

            switch (scanner.nextInt()){
                case 1 ->{

                }
                case 2 ->{
                    signIn();
                }
                case 0 -> {
                    isExisted = true;
                }
                default -> System.out.println("Invalit Command!");
            }

        }

    }

    private static void signIn() {
        System.out.println("Enter your email: ");
        String email =strScanner.nextLine();
        System.out.println("Enter your password");
        String password= strScanner.nextLine();
        User user = authService.signIn(email, password);
        if (user == null){
            System.out.println("User not found!");
            return;
        }
        if (user.getRole().equals(Role.TEACHER)) {
            TeacherUi.teacherUi(user);
        }
        else if (user.getRole().equals(Role.STUDENT)) {
            StudentUi.studentUi(user);
        } else if (user.getRole().equals(Role.ADMIN)) {
            AdminUi.adminUi(user);
        }


    }
}