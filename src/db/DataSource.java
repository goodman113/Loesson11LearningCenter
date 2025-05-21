package db;

import entity.Attendance;
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
    public static ArrayList<User> users = new ArrayList<>();
    public static Set<User> teachers = new HashSet<>();
    public static Set<Group> groups = new HashSet<>();
    public static Set<Attendance> attendances = new HashSet<>();
    public static User currentUser = null;
    static {
        User admin = new User("admin","admin","admin", Role.ADMIN);
        User teacher1 = new User("teacher1","t1","t1", Role.TEACHER);
        User teacher2 = new User("teacher2","t2","t2", Role.TEACHER);
        Student a = new Student("a","a","a", Role.STUDENT);
        Student b = new Student("b","b","b", Role.STUDENT);
        Group group1 = new Group("g54",9,teacher1,new HashSet<>());
        Group group2 = new Group("g55",10,teacher2,new HashSet<>());
        users.add(admin);
        users.add(teacher1);
        users.add(teacher2);
        users.add(a);
        users.add(b);
        students.add(a);
        students.add(b);
        teachers.add(teacher1);
        teachers.add(teacher2);
        groups.add(group1);
        groups.add(group2);
    }
}
