package com.learning.app.datamodel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@IdClass(StudentCourseRelation.class)
public class StudentCourseRelation implements Serializable {

    @Id
    String studentId;
    @Id
    String courseId;

    public StudentCourseRelation() {
    }

    public StudentCourseRelation(String studentId, String courseId) {
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
