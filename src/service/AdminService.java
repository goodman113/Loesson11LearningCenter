package service;

import entity.User;
import entity.enums.Role;

import java.util.Objects;

import static db.DataSource.scanner;
import static db.DataSource.strScanner;
import static db.Storage.users;
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
                    users.add(user);
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
                                System.out.println("enter teacher id:");
                                String id = strScanner.nextLine();
                                for (User user : users) {
                                    if ((Objects.equals(id, user.getId())) && (Objects.equals(user.getRole(), TEACHER))) {
                                        System.out.println("enter name:");
                                        user.setFullName(strScanner.nextLine());
                                        System.out.println("enter email:");
                                        user.setEmail(strScanner.nextLine());
                                        System.out.println("enter password:");
                                        user.setPassword(strScanner.nextLine());
                                        System.out.println("<<- successful ->>");
                                    }
                                }
                            }
                            case 2 -> {
                                System.out.println("enter student id:");
                                String id = strScanner.nextLine();
                                for (User user : users) {
                                    if ((Objects.equals(id, user.getId())) && (Objects.equals(user.getRole(), STUDENT))) {
                                        System.out.println("enter name:");
                                        user.setFullName(strScanner.nextLine());
                                        System.out.println("enter email:");
                                        user.setEmail(strScanner.nextLine());
                                        System.out.println("enter password:");
                                        user.setPassword(strScanner.nextLine());
                                        System.out.println("<<- successful ->>");
                                    }
                                }
                            }
                        }


                    }
                }
                case 4 -> {

                }


            }


        }
    }
}





