package com.learning.app.controller;

import com.learning.app.controller.annotation.Verification;
import com.learning.app.domain.StudentCourseRelationDTO;
import com.learning.app.domain.StudentDTO;
import com.learning.app.domain.inbound.StudentDTOIn;
import com.learning.app.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    IStudentService studentService;

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO createStudent(@RequestBody StudentDTOIn studentDTOIn) {
        return studentService.createStudent(studentDTOIn);
    }

    @Verification(role = "STUDENT")
    @PostMapping("/student/enroll")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentCourseRelationDTO enrollCourse(@RequestBody StudentCourseRelationDTO scrDTO) {
        return studentService.enrollCourse(scrDTO);
    }

    @Verification(role = "ADMIN")
    @DeleteMapping("/student/cancel")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelCourse(@RequestBody StudentCourseRelationDTO scrDTO) {
        studentService.cancelCourse(scrDTO);
    }

}
