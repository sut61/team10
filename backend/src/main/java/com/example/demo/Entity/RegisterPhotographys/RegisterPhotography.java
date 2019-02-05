package com.example.demo.Entity.RegisterPhotographys;

import com.example.demo.Entity.Member;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RegisterPhotography {
    @Id
    @SequenceGenerator(name="registerPhotography_seq",sequenceName="registerPhotography_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="registerPhotography_seq")
    private Long id;
    private String message;

    @Temporal(TemporalType.DATE)
    private @io.micrometer.core.lang.NonNull
    Date registerDate;

    @ManyToOne
    private Member member ;
    @ManyToOne
    private Camara camara ;
    @ManyToOne
    private PhotographyType photographyType ;
    @ManyToOne
    private Instructor instructor ;
    @ManyToOne
    private SkillLevel skillLevel ;
    @ManyToOne
    private StudyTime studyTime ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Camara getCamara() {
        return camara;
    }

    public void setCamara(Camara camara) {
        this.camara = camara;
    }

    public PhotographyType getPhotographyType() {
        return photographyType;
    }

    public void setPhotographyType(PhotographyType photographyType) {
        this.photographyType = photographyType;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }

    public StudyTime getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(StudyTime studyTime) {
        this.studyTime = studyTime;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }


}
