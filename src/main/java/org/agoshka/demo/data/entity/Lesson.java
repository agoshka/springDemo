package org.agoshka.demo.data.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author go
 */
@Entity
public class Lesson {

    
    public enum Status {
        Planned,
        Finished
    }
    @Id
    @GeneratedValue
    private int id;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    private Status status = Status.Planned;
    @ManyToOne
    private Course course;
    static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    @Override
    public String toString() {
        return  String.format("course %d %s", id, formatter.format(date), status.name());
    }
    
    boolean isFinished() {
        return status == Status.Finished;
    }
    
}
