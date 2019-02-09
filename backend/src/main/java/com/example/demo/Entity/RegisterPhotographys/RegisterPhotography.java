package com.example.demo.Entity.RegisterPhotographys;

import com.example.demo.Entity.Member;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class RegisterPhotography {
    @Id
    @SequenceGenerator(name="registerPhotography_seq",sequenceName="registerPhotography_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="registerPhotography_seq")
    private Long id;

    @NotNull
    @Size(min = 2 ,max = 30)
    @Pattern(regexp = "[a-zA-Z0-9ก-๙]+")
    @Column(unique = true)
    private String message;

    @Temporal(TemporalType.DATE)
    private @io.micrometer.core.lang.NonNull
    Date registerDate;

    @NotNull
    @ManyToOne
    private Member member ;

    @NotNull
    @ManyToOne
    private Camara camara ;

    @NotNull
    @ManyToOne
    private PhotographyType photographyType ;

    @NotNull
    @ManyToOne
    private Instructor instructor ;

    @NotNull
    @ManyToOne
    private SkillLevel skillLevel ;

    @NotNull
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
