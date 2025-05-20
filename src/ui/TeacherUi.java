package ui;

import entity.Attendance;
import entity.Group;
import entity.User;
import service.GroupService;
import service.StudentService;
import service.TeacherService;

import java.util.List;
import entity.*;

import java.time.LocalDate;

import static db.DataSource.*;

public class TeacherUi {
    public static User currentUser;


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
                        showStudents();
                        System.out.println("enter student id:");
                        User student = StudentService.findStudentById(strScanner.nextLine());
                        if (student==null){
                            System.out.println("no students are found!");
                            return;
                        }
                        GroupService.showGroups(currentUser.getId());
                        System.out.println("enter group id:");
                        Group group = GroupService.findGroupById(user, strScanner.nextLine());
                        if (group==null){
                            System.out.println("no groups are found");
                            return;
                        }
                        GroupService.addStudentToGroup(student,group);
                    }
                    case "2"->{
                        GroupService.showGroups(currentUser.getId());
                        System.out.println("enter group id:");
                        Group group = GroupService.findGroupById(user, strScanner.nextLine());
                        if (group==null){
                            System.out.println("no groups are found");
                            return;
                        }
                        GroupService.showGroupStudent(group);
                        System.out.println("enter student id:");
                        User student = StudentService.findStudentById(strScanner.nextLine());
                        if (student==null){
                            System.out.println("no students are found!");
                            return;
                        }
                        if (GroupService.getGroupStudent(student,group)==null){
                            System.out.println("this student does not belong to this group");
                            return;
                        }
                        GroupService.deleteStudentFromGroup(student,group);
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
        System.out.println("enter the year");
        int year = scanner.nextInt();
        if (year<2025){
            System.out.println("do not enter past year!");
            return;
        }
        System.out.println("enter the month");
        int month = scanner.nextInt();
        if (1>month||12<month||month>Integer.parseInt(String.valueOf(LocalDate.now().getMonth()))){
            System.out.println("wrong month entered");
            return;
        }
        System.out.println("enter day");
        int day = checkDay(month);
        LocalDate attendanceDay = LocalDate.of(2025, month, day);
        showStudents();
    }

    private void showStudents() {
        for(Student student : students){

        }
    }


    private static int checkDay(int month) {
        int maxDay = switch (month) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28;
            default -> 31;
        };

        System.out.print("Enter a day (1-" + maxDay + "): ");
        int day = scanner.nextInt();


        if (day < 1 || day > maxDay) {
            System.out.println("Invalid day. Please try again.");
            return checkDay(month);
        }
        return day;
    }
}
