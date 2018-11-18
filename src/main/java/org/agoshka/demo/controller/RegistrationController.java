package org.agoshka.demo.controller;

import java.util.Map;
import org.agoshka.demo.data.DemoDataException;
import org.agoshka.demo.data.domain.User;
import org.agoshka.demo.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author go
 */
@Controller
public class RegistrationController {
    @Autowired
//    UserRepository userRepo;
    UserService serv;
           
    @GetMapping("registration")
    public String getRegistration(){
        return "registration";
    }
    
    @PostMapping("registration")
    public String addUser(User user, Map<String, Object> model){
        try{ 
            serv.addNewUser(user);
        } catch (DemoDataException e) {
            model.put("message", e.getMessage());
            return "registration";
        }
        return "redirect:/login";
    }
    

}
