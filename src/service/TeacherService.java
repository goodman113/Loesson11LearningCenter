package service;
import entity.Attendance;
import entity.Group;
import entity.Student;
import entity.User;

import static db.DataSource.*;
import static service.StudentService.showStudents;

public class TeacherService {

public static void service(){

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
                Group group = GroupService.findGroupById(currentUser, strScanner.nextLine());
                if (group==null){
                    System.out.println("no groups are found");
                    return;
                }
                GroupService.addStudentToGroup(student,group);
            }
            case "2"->{
                GroupService.showGroups(currentUser.getId());
                System.out.println("enter group id:");
                Group group = GroupService.findGroupById(currentUser, strScanner.nextLine());
                if (group==null){
                    System.out.println("no groups are found");
                    return;
                }
                GroupService.showGroupStudent(group);
                System.out.println("enter student id:");
                Student student = StudentService.findStudentById(strScanner.nextLine());
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

            }
            case "4"->{
                showAttendances();
            }
            case "5"->{
                MarkStudent();
            }
        }
    }
}

    private static void MarkStudent() {
        GroupService.showGroups(currentUser.getId());
        System.out.println("enter group id:");
        Group group = GroupService.findGroupById(currentUser, strScanner.nextLine());
        if (group==null){
            System.out.println("no groups are found");
            return;
        }
        GroupService.showGroupStudent(group);
        System.out.println("enter student id:");
        Student student = StudentService.findStudentById(strScanner.nextLine());
        if (student==null){
            System.out.println("no students are found!");
            return;
        }
        if (GroupService.getGroupStudent(student,group)==null){
            System.out.println("this student does not belong to this group");
            return;
        }
        int mark = checkMark();
        student.setMarks(currentUser,mark);
    }

    private static int checkMark() {
        System.out.println("enter grade:");
        int mark = scanner.nextInt();
        if (mark<=0||mark>10)checkMark();
        return mark;
    }

    private static void showAttendances() {
        for (Attendance attendance : attendances) {
            System.out.println(attendance);
        }
    }


    public  static User findStudentById(String id){
         for (Student student : students) {
             if (student.getId().equals(id)){
                 return student;
             }
         }
         return null;
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
