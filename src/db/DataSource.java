package db;

import entity.User;
import entity.enums.Role;

import java.util.ArrayList;
import java.util.Scanner;

public class DataSource {
    public static Scanner scanner  =new Scanner(System.in);
    public static Scanner strScanner  =new Scanner(System.in);
    public static ArrayList<User> students = new ArrayList<>();
    public static ArrayList<User> teachers = new ArrayList<>();
    static {
        User admin = new User("admin","admin","admin", Role.ADMIN);
        User teacher1 = new User("teacher1","teacher1","teacher1", Role.STUDENT);
        User teacher2 = new User("teacher2","teacher2","teacher2", Role.STUDENT);
        User a = new User("a","a","a", Role.STUDENT);
        User b = new User("b","b","b", Role.STUDENT);
    }
}
