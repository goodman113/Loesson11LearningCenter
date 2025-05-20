package ui;

import entity.Attendance;
import entity.Group;
import entity.Student;
import entity.User;

import static db.DataSource.*;

public class StudentUi {
    public static User currentUser;
    public void studentUi(User user) {
        currentUser = user;
        while (true) {
            System.out.println("""
                    0 exit
                    1 My marks
                    2 My attendance
                    """);


            switch (strScanner.nextLine()) {
                case "0" -> {
                    return;
                }
                case "1" -> myMarks();
                case "2" -> myAttendance();
            }
        }

    }

    private void myAttendance() {
//        Attendance attendance = new Attendance();
//        System.out.println(attendance.getAttendedStudents());

        for (Group group : groups) {
            if (group.getGroupStudents().equals(currentUser)){
                System.out.println(group);
            }
        }
    }

    private void myMarks() {
       Student student = new Student();
        for (int i = 0; i < students.size(); i++) {
            System.out.println(student.getMarks());
        }
    }
}
