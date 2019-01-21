package com.example.demo.Entity;

import javax.persistence.*;

@Entity
public class TimeStudio {
    @Id
    @SequenceGenerator(name="timeStudio_seq",sequenceName="timeStudio_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="timeStudio_seq")
    private Long id;
    private String time_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime_name() {
        return time_name;
    }

    public void setTime_name(String time_name) {
        this.time_name = time_name;
    }


}
