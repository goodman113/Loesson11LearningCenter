package db;

import entity.User;
import entity.enums.Role;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class DataSource {
    public static Scanner scanner  =new Scanner(System.in);
    public static Scanner strScanner  =new Scanner(System.in);
    Set<User> users = new HashSet<>();
    static {
        User admin = new User("admin","admin","admin", Role.ADMIN);
        User teacher1 = new User("teacher1","teacher1","teacher1", Role.TEACHER);
        User teacher2 = new User("teacher2","teacher2","teacher2", Role.STUDENT);
        User a = new User("a","a","a", Role.STUDENT);
        User b = new User("b","b","b", Role.STUDENT);
    }
}
