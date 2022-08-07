package com.learning.app.services;

import com.learning.app.domain.CourseDTO;
import com.learning.app.domain.inbound.CourseDTOIn;

import java.util.List;

public interface ICourseService {

    CourseDTO createCourse(CourseDTOIn courseDTOIn);

    void updateCourseById(String id, CourseDTOIn courseDTOIn);

    void deleteCourseById(String id);

    List<CourseDTO> getAllCourses();
}
