package service;

import entity.Group;
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
                    3 edit techer/student
                    4 delete techer/student
                    5 create group
                    6 edit group
                    """);
            switch (scanner.nextInt()) {
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





