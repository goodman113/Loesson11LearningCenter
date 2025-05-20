package service;

import entity.User;
import entity.enums.Role;

import static db.DataSource.scanner;
import static db.DataSource.strScanner;

public class AdminService {

    public void menu()
    {
        while (true)
        {
            System.out.println("""
                    0 exit
                    1 add teacher
                    2 add student
                    3 edit techer/student
                    4 delete techer/student
                    5 create group
                    6 edit group
                    """);
            switch (scanner.nextInt())
            {
                case 1->{
                    User user=new User();
                    System.out.println("enter name:");
                    user.setFullName(strScanner.nextLine());
                    System.out.println("enter email:");
                    user.setEmail(strScanner.nextLine());
                    System.out.println("enter password:");
                    user.setPassword(strScanner.nextLine());
                    user.setRole(Role.TEACHER);
                    //add list
                }
                case 3->{

                }

            }

        }
    }

}
