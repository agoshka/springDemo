package org.agoshka.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.agoshka.demo.data.entity.User;
import org.agoshka.demo.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author go
 */
@Controller
public class UsersController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping(value="/users")
    public String getUsers(Map<String, Object> model) {
        Map<String,String> repo = new HashMap<>();
        List<User> users = userService.getAllUsers();
        model.put("users", users);
        return "users";
    }
    @GetMapping("/users/{id}")
    public String getUser(@PathVariable int id, Map<String, Object> model) {
        User u = userService.getUser(id);
        model.put("user", u);
        return "userInfo";
        
    }
    @PostMapping("/users")
    public String addUser(@RequestParam String name, Map<String,Object> model) {
        userService.addNewUser(name);
        return getUsers(model);
    }
    
    @DeleteMapping("/users/{id}")
    public String removeUser(@PathVariable int id, Map<String,Object> model) {
        userService.removeUser(id);
        return getUser(0, model);
    }
 
   }
