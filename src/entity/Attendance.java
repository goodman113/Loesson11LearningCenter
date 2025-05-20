package entity;

import java.time.LocalDate;
import java.util.List;

public class Attendance {
    private String id;
    private LocalDate date;
    private String groupId;
    private User teacher;
    private List<StudentAttendanceDaily> attendedStudents;


}
