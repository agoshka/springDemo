package org.agoshka.demo.data.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


/**
 *
 * @author go
 */
@Entity
public class Course implements Serializable {
    public enum Status {
        Starting,
        Active,
        Finished
    }
    @Id
    @GeneratedValue
    private int id;
    private String Name;
    private int lessonCount;
    private Status state = Status.Starting;
    @ManyToMany(fetch = FetchType.EAGER)
    Set<User> users;

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getLessonCount() {
        return lessonCount;
    }

    public void setLessonCount(int lessonCount) {
        this.lessonCount = lessonCount;
    }

    public Status getState() {
        return state;
    }

    public void setState(Status state) {
        this.state = state;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
    
    public void addUser(User user){
        if (users == null) {
            users = new HashSet<>();
        }
        users.add(user);
    }
    
    
    
}
