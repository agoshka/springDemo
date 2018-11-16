package org.agoshka.demo.data.repo;

import org.agoshka.demo.data.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author go
 */
public interface LessonRepository extends JpaRepository<Lesson, Integer>{
    
}
