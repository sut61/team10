package com.example.demo.Entity.RegisterPhotographys;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class PhotographyType {
    @Id
    @SequenceGenerator(name="photographyTypey_seq",sequenceName="photographyTypey_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="photographyTypey_seq")
    private Long id;
    @NotNull private String photographyType;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhotographyType() {
        return photographyType;
    }

    public void setPhotographyType(String photographyType) {
        this.photographyType = photographyType;
    }


}
