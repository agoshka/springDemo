
package org.agoshka.demo.data.service;

import java.util.List;
import org.agoshka.demo.data.entity.User;

/**
 *
 * @author go
@ */
public interface UserService {
    
    List<User> getAllUsers() ;
    
    User addNewUser(String name);
    
    void removeUser(int id);

    public User getUser(int id);
    
}
