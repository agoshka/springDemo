package org.agoshka.demo.data.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.transaction.Transactional;
import org.agoshka.demo.data.domain.Course;
import org.agoshka.demo.data.domain.Role;
import org.agoshka.demo.data.repo.CourseRepository;
import org.agoshka.demo.data.domain.User;
import org.agoshka.demo.data.repo.UserRepository;
import org.agoshka.demo.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.agoshka.demo.data.service.DataGenerator;

/**
 *
 * @author go
 */
@Repository
public class DataGeneratorImpl implements DataGenerator {
    @Autowired
    UserService userService;
    
    @Autowired
    UserRepository userRepo;

    @Autowired
    CourseRepository courseRepo;
    
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public void generateTemplateData() {
        addRandomUsers();
        addRandomCourses();
    }
    
    @Transactional(Transactional.TxType.REQUIRED)
    public void addRandomUsers() {
        String[] names = {"admin", "u1", "u2", "u3"};
        for (String s: names) {
            User u = new User();
            u.setName(s);
            u.setActive(true);
            
            if (s.equals(names[0])) {
                u.setRoles(Collections.singleton(Role.ADMIN));
                u.setPassword("1234");
            } else {
                u.setRoles(Collections.singleton(Role.USER));
                u.setPassword("22");
            }
            userRepo.save(u);
        }
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void addRandomCourses() {
        List<User> users = userService.getAllUsers();
        Random  r = new Random();
        
        String[] names = {"English", "Yoga", "Massage", "Back"};
        for (String s: names) {
            Course c = new Course();
            c.setName(s);
            
            int index = r.nextInt(users.size());
            if (index >= 0 && index < users.size()) {
                User u = users.get(index);
                if (u != null) {
                    c.addUser(u);
                }
            }
            courseRepo.save(c);
        }
    }
    
}
