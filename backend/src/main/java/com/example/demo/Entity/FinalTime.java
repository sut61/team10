package com.example.demo.Entity;

import lombok.NonNull;
import javax.persistence.*;


@Entity
@Table( name = "FinalTime")
public class FinalTime {
    @Id
    @SequenceGenerator(name = "finalTime_seq", sequenceName = "finalTime_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "finalTime_seq")
    @Column(name = "FinalTime_ID", unique = true, nullable = false)
    private @NonNull Long id;
    private @NonNull String finalTimes;
    public String getFinalTime() {
        return finalTimes;
    }

    public void setFinalTime(String finalTimes) {
        this.finalTimes = finalTimes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public FinalTime() {}
    public FinalTime(String finalTimes) {
        this.finalTimes = finalTimes;
    }
}


