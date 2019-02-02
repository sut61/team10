package com.example.demo.Entity.RegisterPhotographys;

import javax.persistence.*;

@Entity
public class StudyTime {
    @Id
    @SequenceGenerator(name="studyTime_seq",sequenceName="studyTime_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="studyTime_seq")
    private Long id;
    private String studyTime;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(String studyTime) {
        this.studyTime = studyTime;
    }

}
