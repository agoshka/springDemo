package org.agoshka.demo;

/**
 *
 * @author go
 */
public class DemoBean {
    
    private String name;
    
    public String getName() {
        return name == null ? "world" : name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
