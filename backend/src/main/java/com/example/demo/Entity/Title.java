package com.example.demo.Entity;

import javax.persistence.*;

@Entity
public class Title {

    @Id
    @SequenceGenerator(name="title_seq",sequenceName="title_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="title_seq")
    private  Long id;

    private String title;

    public Title(){}

    public Title(String title){ this.title = title; }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }


}
