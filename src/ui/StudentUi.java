package ui;

import entity.User;

import static db.DataSource.*;

public class StudentUi {

    public void studentUi(User user) {

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

    }

    private void myMarks() {
    }
}
