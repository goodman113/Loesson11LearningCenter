package service;

import entity.*;
import entity.enums.AttendanceStatus;

import java.time.LocalDate;
import java.util.*;

import static db.DataSource.*;
import static service.GroupService.*;
import static service.StudentService.showStudents;

public class TeacherService {

    public static void service() {

        while (true) {
            System.out.println("""
                    0 exit
                    1 add student
                    2 remove student
                    3 attendance
                    4 show attendance
                    5 mark
                    """);
            switch (strScanner.nextLine()) {
                case "0" -> {
                    return;
                }
                case "1" -> {
                    showStudents();
                    System.out.println("enter student id:");
                    Student student = StudentService.findStudentById(strScanner.nextLine());
                    if (student == null) {
                        System.out.println("no students are found!");
                        return;
                    }
                    showGroups(currentUser.getId());
                    System.out.println("enter group id:");
                    Group group = GroupService.findGroupById(currentUser, strScanner.nextLine());
                    if (group == null) {
                        System.out.println("no groups are found");
                        return;
                    }
                    System.out.println(GroupService.addStudentToGroup(student, group) ? "student successfully added " : "student could not be added");
                }
                case "2" -> {
                    showGroups(currentUser.getId());
                    System.out.println("enter group id:");
                    Group group = GroupService.findGroupById(currentUser, strScanner.nextLine());
                    if (group == null) {
                        System.out.println("no groups are found");
                        return;
                    }
                    GroupService.showGroupStudent(group);
                    System.out.println("enter student id:");
                    Student student = StudentService.findStudentById(strScanner.nextLine());
                    if (student == null) {
                        System.out.println("no students are found!");
                        return;
                    }
                    if (GroupService.getGroupStudent(student, group) == null) {
                        System.out.println("this student does not belong to this group");
                        return;
                    }
                    System.out.println(GroupService.deleteStudentFromGroup(student, group) ? "successfully deleted " : "could not be deleted");
                }
                case "3" -> {
                    makeAttendance();
                }
                case "4" -> {
                    showAttendances();
                }
                case "5" -> {
                    MarkStudent();
                }
            }
        }
    }

    private static void makeAttendance() {
        showGroups(currentUser.getId());
        System.out.println("enter group id: ");
        Group groupById = findGroupById(currentUser, strScanner.nextLine());
        if (groupById == null) {
            System.out.println("group not found!");
            return;
        }
        List<StudentAttendanceDaily> studentAttendanceDaily = new ArrayList<>();
        System.out.println(groupById.getGroupStudents().size());
        for (Student groupStudent : groupById.getGroupStudents()) {
            studentAttendanceDaily.add(new StudentAttendanceDaily(groupStudent.getId(), groupStudent.getFullName(), AttendanceStatus.NOT_ATTENDED));
        }
        System.out.println("enter 1 for students who attended to lesson and 2 for opposite ones");
        Attendance attendance = new Attendance(LocalDate.now(), groupById.getId(), currentUser, studentAttendanceDaily);
        attendances.add(attendance);
        for (int i = 0; i < attendance.getAttendedStudents().size(); i++) {
            StudentAttendanceDaily currentStudent = attendance.getAttendedStudents().get(i);
            System.out.println(currentStudent);
            System.out.println("did "+currentStudent.getStudentName()+" come? =>   1= ✅"+"2= ❌");
            switch (scanner.nextInt()) {
                case 1 -> currentStudent.setStatus(AttendanceStatus.ATTENDED);
                case 2 -> currentStudent.setStatus(AttendanceStatus.NOT_ATTENDED);
                default -> {
                    System.out.println("we ain't playing here buddy ");
                    i--;
                }
            }
        }
    }
    private static void MarkStudent() {
        showGroups(currentUser.getId());
        System.out.println("enter group id:");
        Group group = GroupService.findGroupById(currentUser, strScanner.nextLine());
        if (group == null) {
            System.out.println("no groups are found");
            return;
        }
        GroupService.showGroupStudent(group);
        System.out.println("enter student id:");
        Student student = StudentService.findStudentById(strScanner.nextLine());
        if (student == null) {
            System.out.println("no students are found!");
            return;
        }
        if (GroupService.getGroupStudent(student, group) == null) {
            System.out.println("this student does not belong to this group");
            return;
        }
        int mark = checkMark();
        student.setMarks(currentUser, mark);
    }

    private static int checkMark() {
        System.out.println("enter grade:");
        int mark = scanner.nextInt();
        if (mark <= 0 || mark > 10) checkMark();
        return mark;
    }

    private static void showAttendances() {
        for (Attendance attendance : attendances) {
            System.out.println(attendance);
        }
    }


    public static User findStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
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
