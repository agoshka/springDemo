package org.agoshka.demo.data.repo;

import org.agoshka.demo.data.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author go
 */
public interface CourseRepository extends JpaRepository<Course, Integer> {
    
}
