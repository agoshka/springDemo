package org.agoshka.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.agoshka.demo.data.domain.Course;
import org.agoshka.demo.data.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author go
 */
@Controller
@RequestMapping(value="/courses")
public class CoursesController {
    @Autowired
    CourseService courseService;
    
    @GetMapping
    public String getCourses(Map<String, Object> model) {
        Map<String,String> repo = new HashMap<>();
        List<Course> courses = courseService.getAllCourses();
        model.put("courses", courses);
        return "courses";
    }
    @GetMapping("/{id}")
    public String getCourse(@PathVariable int id, Map<String, Object> model) {
        Course c = courseService.getCourse(id);
        model.put("course", c);
        return "courseInfo";
        
    }
    @PostMapping("/{id}")
    public String addUser(@PathVariable int id, @RequestParam String userName, Map<String,Object> model) {
        courseService.addNewUserToCourse(id, userName);
        return getCourse(id,model);
    }
    @PostMapping
    public String addCourse(@RequestParam String name, @RequestParam String userName, Map<String,Object> model) {
        courseService.addNewCourse(name, userName);
        return getCourses(model);
    }
    
    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable int id, Map<String,Object> model) {
        courseService.removeCourse(id);
        return getCourse(0, model);
    }
    
}
