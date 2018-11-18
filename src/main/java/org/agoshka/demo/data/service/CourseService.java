package org.agoshka.demo.data.service;

import java.util.List;
import org.agoshka.demo.data.domain.Course;

/**
 *
 * @author go
 */
public interface CourseService {
    List<Course> getAllCourses() ;
    
    Course addNewCourse(String name, String userName);
    
    void removeCourse(int id);

    public Course getCourse(int id);

    void addNewUserToCourse(int id, String userName);
}
