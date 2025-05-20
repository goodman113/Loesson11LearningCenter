package service;

import static db.DataSource.scanner;

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

            }

        }
    }

}
