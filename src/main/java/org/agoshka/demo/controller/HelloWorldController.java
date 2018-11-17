package org.agoshka.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.agoshka.demo.DemoBean;
import org.agoshka.demo.data.entity.User;
import org.agoshka.demo.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.agoshka.demo.data.service.DataGenerator;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HelloWorldController {
    
    @Autowired
    private DemoBean bean;
         
    @GetMapping(value="/")
    public String getHelloWorld(@RequestParam(name = "who", required = false) String who, Map<String, Object> model) {
         if (who != null) {
            bean.setName(who);
        }
         model.put("name", bean.getName());
        return "helloworld";
    }
    
        
    
    
    
    
    
}
