package org.agoshka.demo.data.domain;

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
import javax.persistence.OneToMany;


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
    
    @OneToMany(mappedBy = "course")
    List<Lesson> lessons;
    @OneToMany(mappedBy = "course")
    List<Payment> payments;

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

    public List<Lesson> getLessons() {
        return lessons;
    }

    public List<Payment> getPayments() {
        return payments;
    }
    
    public void addUser(User user){
        if (users == null) {
            users = new HashSet<>();
        }
        users.add(user);
    }
    
    public void addLesson(Lesson lesson){
        if (lessons == null) {
            lessons = new ArrayList<>();
        }
        lessons.add(lesson);
        if (lesson.isFinished()) {
            lessonCount -= 1;
        }
    }
    
    public void addPayment(Payment payment){
        if (payments == null) {
            payments = new ArrayList<>();
        }
        payments.add(payment);
        lessonCount += payment.getCount();
        
    }
    
    
    
}
