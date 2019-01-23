package com.example.demo.Entity;

import javax.persistence.*;

@Entity
public class Gender {

    @Id
    @SequenceGenerator(name="gender_seq",sequenceName="gender_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gender_seq")
    private  Long id;

    private String sex ;

    public Gender(){}

    public Gender(String sex){ this.sex = sex ; }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getSex() { return sex; }

    public void setSex(String sex) { this.sex = sex; }
}
