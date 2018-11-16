/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.agoshka.demo.data.service.impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.agoshka.demo.data.DemoDataException;
import org.agoshka.demo.data.entity.Course;
import org.agoshka.demo.data.entity.User;
import org.agoshka.demo.data.repo.CourseRepository;
import org.agoshka.demo.data.repo.UserRepository;
import org.agoshka.demo.data.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author go
 */
@Repository
@Transactional(Transactional.TxType.REQUIRED)
public class CourseServiceImpl implements CourseService {

    @Autowired
    UserRepository userRepo;
    @Autowired
    CourseRepository courseRepo;
    
    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Course addNewCourse(String name, String userName) {
        Course c = new Course();
        c.setName(name);
        User user = userRepo.findByUserName(userName);
        if (user != null) {
            c.addUser(user);
        }
        courseRepo.save(c);
        return c;
    }

    @Override
    public void removeCourse(int id) {
        courseRepo.deleteById(id);
    }

    @Override
    public Course getCourse(int id) {
        Optional<Course> c = courseRepo.findById(id);
        return c.orElse(null);
    }

    @Override
    public void addNewUserToCourse(int id, String userName) {
        Course c= getCourse(id);
        if (c == null) {
            throw new DemoDataException("Course " + id + " is not found");
        }
        User user = userRepo.findByUserName(userName);
        if (user != null) {
            c.addUser(user);
        }
    }
    
}
