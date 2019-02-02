package com.example.demo.Entity.RegisterPhotographys;

import javax.persistence.*;

@Entity
public class SkillLevel {
    @Id
    @SequenceGenerator(name="skillLevel_seq",sequenceName="skillLevel_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="skillLevel_seq")
    private Long id;
    private String skill;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

}
