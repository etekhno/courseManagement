package com.learning.app.datamodel.repo;

import com.learning.app.datamodel.Course;
import com.learning.app.domain.CourseDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CourseRepo extends PagingAndSortingRepository<Course, String> {

    @Query(" select new com.learning.app.domain.CourseDTO( id, name, description ) from Course ")
    List<CourseDTO> findAllCourses();

}
