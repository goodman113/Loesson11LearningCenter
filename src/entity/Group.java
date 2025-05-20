package entity;

import java.util.Set;
import java.util.UUID;

public class Group {
    private final String id = UUID.randomUUID().toString();
    private String name;
    private Integer maxLessonInMonth;
    private User teacher;
    private Set<User> students;

    public Group(String name, Integer maxLessonInMonth, User teacher, Set<User> students) {
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

    public Set<User> getStudents() {
        return students;
    }

    public void setStudents(Set<User> students) {
        this.students = students;
    }
}
