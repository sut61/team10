package com.example.demo.Entity.RegisterPhotographys;

import javax.persistence.*;

@Entity
public class Camara {
    @Id
    @SequenceGenerator(name="camary_seq",sequenceName="camary_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="camary_seq")
    private Long id;
    private String camaraName;
    private String camaraType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCamaraName() {
        return camaraName;
    }

    public void setCamaraName(String camaraName) {
        this.camaraName = camaraName;
    }

    public String getCamaraType() {
        return camaraType;
    }

    public void setCamaraType(String camaraType) {
        this.camaraType = camaraType;
    }

}
