package com.learning.app.domain;

public class StudentCourseRelationDTO {

    String studentId;
    String courseId;

    public StudentCourseRelationDTO() {
    }

    public StudentCourseRelationDTO(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
