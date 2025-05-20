package entity;

import java.util.List;
import java.util.Objects;

public class Mark {
    private String studentId;
    private String groupId;
    private List<Integer> mark;


    public Mark() {
    }

    public Mark(String studentId, String groupId, List<Integer> mark) {
        this.studentId = studentId;
        this.groupId = groupId;
        this.mark = mark;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<Integer> getMark() {
        return mark;
    }

    public void setMark(List<Integer> mark) {
        this.mark = mark;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark1 = (Mark) o;
        return Objects.equals(studentId, mark1.studentId) && Objects.equals(groupId, mark1.groupId) && Objects.equals(mark, mark1.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, groupId, mark);
    }

    @Override
    public String toString() {
        return "Mark{" +
                "studentId='" + studentId + '\'' +
                ", groupId='" + groupId + '\'' +
                ", mark=" + mark +
                '}';
    }
}
