package entity;

public class Student extends User{
    private StringBuilder marks = new StringBuilder();
    private String groupId;

    public Student(){}

    public Student(String groupId) {
        this.groupId = groupId;
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
                ", marks=" + marks +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}
