package org.agoshka.demo.data.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(
        name ="findAll",
        query = "select U from User U order by U.id")
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ManyToMany(mappedBy="users")
    private List<Course> courses;

    public User() {
    }
    
    public User(String name) {
        setName(name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
