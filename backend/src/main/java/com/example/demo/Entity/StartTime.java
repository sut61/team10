package com.example.demo.Entity;

import lombok.NonNull;
import javax.persistence.*;


@Entity
@Table( name = "StartTime")
public class StartTime {
    @Id
    @SequenceGenerator(name = "startTime_seq", sequenceName = "startTime_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "startTime_seq")
    @Column(name = "StartTime_ID", unique = true, nullable = false)
    private @NonNull Long id;
    private @NonNull String startTimes;
    public String getStratTime() {
        return startTimes;
    }

    public void setStratTime(String startTimes) {
        this.startTimes = startTimes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public StartTime(){}
    public StartTime(String startTimes){
        this.startTimes = startTimes;
    }


}
