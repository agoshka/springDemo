package org.agoshka.demo.data.service.impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.agoshka.demo.data.DemoDataException;
import org.agoshka.demo.data.entity.User;
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
        User user = userRepo.findByUserName(name);
        if (user != null)
            throw new DemoDataException("User");
        user = new User(name);
        userRepo.save(user);
        return user;
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
