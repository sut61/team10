package com.example.demo.Entity;

import javax.persistence.*;

@Entity
public class RoomStudio {

    @Id
    @SequenceGenerator(name="studio_seq",sequenceName="studio_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="studio_seq")
    private Long id;
    private String name;
    private String studio_status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudio_status() {
        return studio_status;
    }

    public void setStudio_status(String studio_status) {
        this.studio_status = studio_status;
    }


}
