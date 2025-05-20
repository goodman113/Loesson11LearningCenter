package ui;

import entity.Attendance;
import entity.Group;
import entity.User;
import service.TeacherService;

import java.util.List;

import static db.DataSource.*;

public class TeacherUi {
    public static User currentUser;
    static TeacherService teacherService = new TeacherService();


    public void teacherUi (User user) {
        currentUser = user;
            while(true){
                // AKBAR 4 show attendance VA 5 mark
                System.out.println("""
                    0 exit
                    1 add student
                    2 remove student
                    3 attendance
                    4 show attendance
                    5 mark
                    """);
                switch (strScanner.nextLine()){
                    case "0"->{
                        return;
                    }
                    case "1"->{
                        teacherService.showGroups(currentUser.getId());
                        System.out.println("enter group id:");
                        String groupId = strScanner.nextLine();

                    }
                    case "2"->{

                    }
                    case "3"->{
                        StudentAttendance();
                    }
                    case "4"->{

                    }
                    case "5"->{

                    }
                }
            }
    }

    private void StudentAttendance() {
        System.out.println("enter the");
    }
}
