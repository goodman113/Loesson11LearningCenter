package entity;

import db.DataSource;
import entity.enums.Role;

import java.util.Date;

public class Student extends User{
    private StringBuilder marks;
    private String groupId;

    public Student(){}

    public Student(String fullName, String email, String password, Role role){
        super(fullName,email,password,Role.STUDENT);
    }


    public StringBuilder getMarks() {
        return marks;
    }

    public void setMarks(User user, int mark) {
        Date date = new Date();
        marks.append("teacher ").append(user.getFullName()).append("gave you ").append(mark).append("in ").append(date).append('\n');
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString()+
                ", marks=" + marks +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}
