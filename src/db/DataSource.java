package db;

import entity.Group;
import entity.Student;
import entity.User;
import entity.enums.Role;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class DataSource {
    public static Scanner scanner  =new Scanner(System.in);
    public static Scanner strScanner  =new Scanner(System.in);

    public static Set<Student> students = new HashSet<>();
    public static Set<User> teachers = new HashSet<>();
    public static Set<Group> groups = new HashSet<>();
    static {
        User admin = new User("admin","admin","admin", Role.ADMIN);
<<<<<<< HEAD
        User teacher1 = new User("teacher1","teacher1","teacher1", Role.STUDENT);
        User teacher2 = new User("teacher2","teacher2","teacher2", Role.STUDENT);
=======
        User teacher1 = new User("teacher1","teacher1","teacher1", Role.TEACHER);
        User teacher2 = new User("teacher2","teacher2","teacher2", Role.TEACHER);
>>>>>>> 58ece0c4f27e49562169e5b09a77c87f9df68306
        User a = new User("a","a","a", Role.STUDENT);
        User b = new User("b","b","b", Role.STUDENT);
    }
}
