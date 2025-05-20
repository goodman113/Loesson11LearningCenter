package entity;

public class Student {
    private User user;
    private StringBuilder marks = new StringBuilder();
    private String groupId;

    public Student(User user, String groupId) {
        this.user = user;
        this.groupId = groupId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public StringBuilder getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks.append(marks);
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
                "user=" + user +
                ", marks=" + marks +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}
