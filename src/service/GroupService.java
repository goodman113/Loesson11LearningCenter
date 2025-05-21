package service;

import entity.Group;
import entity.Student;
import entity.User;

import static db.DataSource.groups;
import static db.DataSource.students;

public class GroupService {
    public static boolean addStudentToGroup(Student student, Group group){
        if (student==null||group==null)return false;
        group.getGroupStudents().add(student);
        return true;
    }
    public static boolean deleteStudentFromGroup(Student student,Group group){
        if (student==null||group==null)return false;
        group.getGroupStudents().remove(student);
        return true;
    }
    public static void showGroups(String teacherId){
        for (Group group : groups) {
            if (group.getTeacher().getId().equals(teacherId)){
                System.out.println(group);
            }

        }
    }
    public static void showGroupStudent(Group group){
        for (User groupStudent : group.getGroupStudents()) {
            System.out.println(groupStudent);
        }
    }

    public static User getGroupStudent(User user,Group group){
        for (User groupStudent : group.getGroupStudents()) {
            if (user.getId().equals(groupStudent.getId()))return groupStudent;
        }
        return null;
    }
    public static Group findGroupById(User user, String id){
        for (Group group : groups) {
            if (group.getId().equals(id)&&group.getTeacher().getId().equals(user.getId())){
                return group;
            }
        }
        return null;
    }
}
