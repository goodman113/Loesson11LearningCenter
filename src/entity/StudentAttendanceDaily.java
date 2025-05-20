package entity;

import entity.enums.AttendanceStatus;

import java.util.UUID;

public class StudentAttendanceDaily {
    private String studentId = UUID.randomUUID().toString();
    private String studentName;
    private AttendanceStatus status;

    public StudentAttendanceDaily(String studentId, String studentName, AttendanceStatus status) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.status = status;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public AttendanceStatus getStatus() {
        return status;
    }

    public void setStatus(AttendanceStatus status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "StudentAttendanceDaily{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", status=" + status +
                '}';
    }
}
