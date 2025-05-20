package ui;

import entity.Attendance;
import entity.User;

import static db.DataSource.*;

public class TeacherUi {


    public void teacherUi (User user) {
   while(true){
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
