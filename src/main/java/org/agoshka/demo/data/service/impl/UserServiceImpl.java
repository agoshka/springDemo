package org.agoshka.demo.data.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.agoshka.demo.data.DemoDataException;
import org.agoshka.demo.data.domain.Role;
import org.agoshka.demo.data.domain.User;
import org.agoshka.demo.data.repo.UserRepository;
import org.agoshka.demo.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional(Transactional.TxType.REQUIRED)
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;
    
    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    
    @Override
    public User addNewUser(String name) {
        User user = new User(name);
        return addNewUser(user);
    }
    
    @Override
    public User addNewUser(User user) {
        if (user.getName().trim().isEmpty()) {
            throw new DemoDataException("Username is empty");
        }
        User userFromDb = userRepo.findByUserName(user.getName());
        if (userFromDb != null) {
            throw new DemoDataException("User is exists");
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return user;
        
    }
    
    public User updateUser(int id, String password, boolean isActive, boolean isAdmin) {
        User u = userRepo.findById(id).orElse(null);
        if ( u == null) {
            throw new DemoDataException ("User is not exist");
        }
        u.setActive(isActive);
        u.setPassword(password);
        u.getRoles().add( isAdmin ? Role.ADMIN : Role.USER);
        userRepo.save(u);
        return u;
    }
    

    @Override
    public void removeUser(int id) {
        Optional<User> u = userRepo.findById(id);
        u.ifPresent(uu -> userRepo.delete(uu));
    }

    @Override
    public User getUser(int id) {
        Optional<User> u = userRepo.findById(id);
        return u.orElse(null);
    }
}
