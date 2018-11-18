package org.agoshka.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HelloWorldController {
    
//    @Autowired
//    private DemoBean bean;
//         
    @GetMapping(value="/")
    public String getHelloWorld() {
        return "helloworld";
    }
   
    
}
