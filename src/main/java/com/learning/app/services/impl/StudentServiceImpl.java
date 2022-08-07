package com.learning.app.services.impl;

import com.learning.app.datamodel.StudentCourseRelation;
import com.learning.app.datamodel.User;
import com.learning.app.datamodel.repo.StudentCourseRelationRepo;
import com.learning.app.datamodel.repo.UserRepo;
import com.learning.app.domain.StudentCourseRelationDTO;
import com.learning.app.domain.StudentDTO;
import com.learning.app.domain.inbound.StudentDTOIn;
import com.learning.app.services.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    StudentCourseRelationRepo studentCourseRelationRepo;

    public StudentDTO createStudent(StudentDTOIn studentDTOIn) {
        ModelMapper mm = new ModelMapper();
        User user = mm.map(studentDTOIn, User.class);
        user.setRole("STUDENT");

        user = userRepo.save(user);
        StudentDTO studentDTO = mm.map(user, StudentDTO.class);
        return studentDTO;
    }

    public StudentCourseRelationDTO enrollCourse(StudentCourseRelationDTO scrDTO) {
        ModelMapper mm = new ModelMapper();
        StudentCourseRelation scr = mm.map(scrDTO, StudentCourseRelation.class);

        scr = studentCourseRelationRepo.save(scr);

        mm.map(scr, scrDTO);
        return scrDTO;
    }

    @Override
    public void cancelCourse(StudentCourseRelationDTO scrDTO) {

        Optional<StudentCourseRelation> scr = studentCourseRelationRepo.findByStudentIdAndCourseId(scrDTO.getStudentId(), scrDTO.getCourseId());

        if(scr.isEmpty())
            throw new IllegalArgumentException("Invalid Input");

        studentCourseRelationRepo.delete(scr.get());
    }
}
