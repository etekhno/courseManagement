package com.learning.app.services;

import com.learning.app.domain.StudentCourseRelationDTO;
import com.learning.app.domain.StudentDTO;
import com.learning.app.domain.inbound.StudentDTOIn;

public interface IStudentService {

    StudentDTO createStudent(StudentDTOIn studentDTOIn);

    StudentCourseRelationDTO enrollCourse(StudentCourseRelationDTO scrDTO);

    void cancelCourse(StudentCourseRelationDTO scrDTO);
}
