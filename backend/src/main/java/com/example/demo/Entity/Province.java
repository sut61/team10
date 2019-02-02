package com.example.demo.Entity;

import javax.persistence.*;

@Entity
public class Province {

    @Id
    @SequenceGenerator(name="poo_seq",sequenceName="poo_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="poo_seq")
    private  Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String   provincename) {
        this.provincename = provincename;
    }

    private String provincename ;

    public Province(){}
}
