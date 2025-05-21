package service;

import entity.Group;
import entity.Student;
import entity.User;
import entity.enums.Role;

import java.util.Objects;

import static db.DataSource.*;

import static entity.enums.Role.STUDENT;
import static entity.enums.Role.TEACHER;

public class AdminService {

    public void service() {
        while (true) {
            System.out.println("""
                    0 exit
                    1 add teacher
                    2 add student
                    3 edit teacher/student
                    4 delete teacher/student
                    5 create group
                    6 edit group
                    """);
            switch (scanner.nextInt()) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    User user = new User();
                    System.out.println("enter name:");
                    user.setFullName(strScanner.nextLine());
                    System.out.println("enter email:");
                    user.setEmail(strScanner.nextLine());
                    System.out.println("enter password:");
                    user.setPassword(strScanner.nextLine());
                    user.setRole(TEACHER);
                    teachers.add(user);
                    users.add(user);
                }
                case 2 -> {
                    addStudent();
                }
                case 3 -> {
                    while (true) {
                        System.out.println("""
                                0 exit
                                1 teacher
                                2 student
                                """);
                        switch (scanner.nextInt()) {
                            case 0 -> {
                                return;
                            }

                            case 1 -> {
                                techershow();
                                System.out.println("enter teacher id:");
                                String id = strScanner.nextLine();
                                for (User teacher : teachers) {
                                    if (Objects.equals(id, teacher.getId())) {
                                        System.out.println("enter name:");
                                        teacher.setFullName(strScanner.nextLine());
                                        System.out.println("enter email:");
                                        teacher.setEmail(strScanner.nextLine());
                                        System.out.println("enter password:");
                                        teacher.setPassword(strScanner.nextLine());
                                        System.out.println("<<- successful ->>");
                                    }
                                }
                            }
                            case 2 -> {
                                studentshow();
                                System.out.println("enter student id:");
                                String id = strScanner.nextLine();
                                for (User student : students) {
                                    if (Objects.equals(id, student.getId())) {
                                        System.out.println("enter name:");
                                        student.setFullName(strScanner.nextLine());
                                        System.out.println("enter email:");
                                        student.setEmail(strScanner.nextLine());
                                        System.out.println("enter password:");
                                        student.setPassword(strScanner.nextLine());
                                        System.out.println("<<- successful ->>");
                                    }
                                }
                            }
                        }


                    }
                }
                case 5 -> {
                    Group group=new Group();
                    System.out.println("enter group name:");
                    group.setName(strScanner.nextLine());
                    System.out.println("enter maxLessonInMonth:");
                    group.setMaxLessonInMonth(scanner.nextInt());
                    techershow();
                    System.out.println("enter teacher id:");
                    String id=strScanner.nextLine();
                    for (User teacher : teachers) {
                        if(Objects.equals(id,teacher.getId()))
                        {
                            group.setTeacher(teacher);
                        }
                    }
                    groups.add(group);
                }

                case 4 -> {
                    while (true){
                        System.out.println("""
                                0 exit
                                1 teacher
                                2 student
                                """);
                        switch (scanner.nextInt()){
                            case 0 -> {
                                return;
                            }
                            case 1 -> {
                                deleteTeacher();
                            }
                            case 2 -> {
                                deleteStudent();
                            }
                        }
                    }
                }

                case 6 -> {
                    editGroup();
                }
            }
        }
    }

    private void addStudent() {
        Student student = new Student();
        System.out.println("Full name: ");
        student.setFullName(strScanner.nextLine());
        System.out.println("Email: ");
        student.setEmail(strScanner.nextLine());
        System.out.println("Password: ");
        student.setPassword(strScanner.nextLine());
        student.setRole(STUDENT);
        students.add(student);
        users.add(student);
    }

    private void deleteStudent() {
        if (students.isEmpty()) {
            System.out.println("No users");
            return;
        }
        for (User user : students) {
            System.out.println(user);
        }
        System.out.println("ID: ");
        String id = strScanner.nextLine();
        for (User user : users) {
            if (user.getId().equals(id)) {
                users.remove(user);
            }
        }
        for (User user : students) {
            if (user.getId().equals(id)) {
                students.remove(user);
                return;
            }
        }
        System.out.println("ID not found");
    }

    private void deleteTeacher() {
        if (teachers.isEmpty()) {
            System.out.println("No users");
            return;
        }
        for (User user : teachers) {
            System.out.println(user);
        }
        System.out.println("ID: ");
        String id = strScanner.nextLine();
        for (User user : users) {
            if (user.getId().equals(id)) {
                users.remove(user);
            }
        }
        for (User user : teachers) {
            if (user.getId().equals(id)) {
                teachers.remove(user);
                return;
            }
        }
        System.out.println("ID not found");
    }

    private void editGroup() {
        if (groups.isEmpty()){
            System.out.println("Groups not found");
            return;
        }
        for (Group group : groups) {
            System.out.println(group);
        }
        Group gr = new Group();
        System.out.println("Group ID: ");
        String id = strScanner.nextLine();
        for (Group group : groups) {
            if (group.getId().equals(id)){
                gr = group;
                editGroupFields(gr);
                return;
            }
        }
    }

    private void editGroupFields(Group group) {
        while (true) {
            System.out.println("""
                    0 exit
                    1 name
                    2 maxLessonsInMonth
                    3 teacher
                    """);
            switch (scanner.nextInt()){
                case 0 -> {
                    return;
                }
                case 1 -> {
                    group.setName(strScanner.nextLine());
                }
                case 2 -> {
                    group.setMaxLessonInMonth(scanner.nextInt());
                }
                case 3 -> {
                    for (User teacher : teachers) {
                        System.out.println(teacher);
                    }
                    System.out.println("teacher ID");
                    String id = strScanner.nextLine();
                    for (User teacher : teachers) {
                        if (teacher.getId().equals(id)){
                            group.setTeacher(teacher);
                            return;
                        }
                    }
                    System.out.println("ID not found");
                }
            }
        }
    }

    private void techershow() {
        for (User teacher : teachers) {
                System.out.println("<< "+teacher+" >>");
        }
    }
    private void studentshow() {
        for (User student : students) {
                System.out.println("<< "+student+" >>");
        }
    }

}





