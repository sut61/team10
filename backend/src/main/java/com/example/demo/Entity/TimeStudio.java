package com.example.demo.Entity;

import javax.persistence.*;

@Entity
public class TimeStudio {
    @Id
    @SequenceGenerator(name="timeStudio_seq",sequenceName="timeStudio_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="timeStudio_seq")
    private Long id;
    private String timeName;

    public String getTimeName() {
        return timeName;
    }

    public void setTimeName(String timeName) {
        this.timeName = timeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




}
