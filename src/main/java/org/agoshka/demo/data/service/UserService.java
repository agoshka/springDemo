
package org.agoshka.demo.data.service;

import java.util.List;
import org.agoshka.demo.data.domain.User;

/**
 *
 * @author go
@ */
public interface UserService {
    
    List<User> getAllUsers() ;
    
    User addNewUser(String name);
    
    User addNewUser(User user);
    
    User updateUser(int id, String password, boolean isActive, boolean isAdmin);
    
    void removeUser(int id);

    public User getUser(int id);
    
}
