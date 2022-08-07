package com.learning.app.services.impl;

import com.learning.app.datamodel.Course;
import com.learning.app.datamodel.repo.CourseRepo;
import com.learning.app.domain.CourseDTO;
import com.learning.app.domain.inbound.CourseDTOIn;
import com.learning.app.services.ICourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    CourseRepo courseRepo;

    public CourseDTO createCourse(CourseDTOIn courseDTOIn) {
        ModelMapper mm = new ModelMapper();
        Course course = mm.map(courseDTOIn, Course.class);
        course = courseRepo.save(course);

        CourseDTO courseDTO = mm.map(course, CourseDTO.class);
        return courseDTO;
    }

    public void updateCourseById(String id, CourseDTOIn courseDTOIn) {
        Optional<Course> course = courseRepo.findById(id);

        if(course.isEmpty())
            throw new IllegalArgumentException("Id not correct");

        Course updatedCourse = course.get();
        ModelMapper mm = new ModelMapper();
        mm.map(courseDTOIn, updatedCourse);

        courseRepo.save(updatedCourse);
    }

    public void deleteCourseById(String id) {

        Optional<Course> course = courseRepo.findById(id);

        if(course.isEmpty())
            throw new IllegalArgumentException("Id not correct");

        courseRepo.deleteById(id);
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepo.findAllCourses();
    }

}
