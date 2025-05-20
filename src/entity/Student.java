package entity;

import db.DataSource;

import java.util.Date;

public class Student extends User{
    private StringBuilder marks = new StringBuilder();
    private String groupId;

    public Student(String groupId) {
        this.groupId = groupId;
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
                ", marks=" + marks +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}
