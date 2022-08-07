package com.learning.app.datamodel.repo;

import com.learning.app.datamodel.StudentCourseRelation;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface StudentCourseRelationRepo extends PagingAndSortingRepository<StudentCourseRelation, String> {

    Optional<StudentCourseRelation> findByStudentIdAndCourseId(String studentId, String courseId);
}
