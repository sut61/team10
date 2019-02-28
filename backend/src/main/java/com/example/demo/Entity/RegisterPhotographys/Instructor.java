package com.example.demo.Entity.RegisterPhotographys;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Instructor {
    @Id
    @SequenceGenerator(name="instructor_seq",sequenceName="instructor_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="instructor_seq")
    private Long id;
    @NotNull private String instructorName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }



}
