package service;

import entity.Group;
import entity.User;

import static db.DataSource.groups;

public class GroupService {
    public static boolean addStudentToGroup(User user, Group group){
        if (user==null||group==null)return false;
        group.getGroupStudents().add(user);
        return true;
    }
    public static boolean deleteStudentFromGroup(User user,Group group){
        if (user==null||group==null)return false;
        group.getGroupStudents().remove(user);
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
