package entity;

import java.util.Set;
import java.util.UUID;

public class Group {
    private final String id = UUID.randomUUID().toString();
    private String name;
    private Integer maxLessonInMonth;
    private User teacher;
    private Set<Student> students;
    public Group() {
    }




    public Group(String name, Integer maxLessonInMonth, User teacher,Set<Student> students) {
        this.name = name;
        this.maxLessonInMonth = maxLessonInMonth;
        this.teacher = teacher;
        this.students = students;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxLessonInMonth() {
        return maxLessonInMonth;
    }

    public void setMaxLessonInMonth(Integer maxLessonInMonth) {
        this.maxLessonInMonth = maxLessonInMonth;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public Set<Student> getGroupStudents() {
        return students;
    }

    public void setGroupStudents(Set<Student> groupStudents) {
        this.students = groupStudents;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", maxLessonInMonth=" + maxLessonInMonth +
                ", teacher=" + teacher +
                ", groupStudents=" + students +
                '}';
    }
}
