package com.learning.app.controller;

import com.learning.app.domain.CourseDTO;
import com.learning.app.domain.inbound.CourseDTOIn;
import com.learning.app.services.ICourseService;
import com.learning.app.services.common.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.InputMismatchException;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    ICourseService courseService;

    @Autowired
    IAuthService authService;

    @PostMapping("/course")
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDTO createCourse(@RequestBody CourseDTOIn courseDTOIn) {

        Boolean validUser = authService.isAdminUser();

        if(validUser == false)
            throw new InputMismatchException("");

        return courseService.createCourse(courseDTOIn);
    }

    @PutMapping("/course/{courseId}")
    public void updateCourse(@PathVariable("courseId") String id, @RequestBody CourseDTOIn courseDTOIn) {
        Boolean validUser = authService.isAdminUser();

        if(validUser == false)
            throw new InputMismatchException("");

        courseService.updateCourseById(id, courseDTOIn);
    }

    @DeleteMapping("/course/{courseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable("courseId") String id) {

        Boolean validUser = authService.isAdminUser();

        if(validUser == false)
            throw new InputMismatchException("");

        courseService.deleteCourseById(id);
    }

    @GetMapping("/course")
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

}
