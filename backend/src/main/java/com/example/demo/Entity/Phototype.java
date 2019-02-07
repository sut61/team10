package com.example.demo.Entity;

import io.micrometer.core.lang.NonNull;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Table(name="Phototype")
public class Phototype {


    @Id
    @SequenceGenerator(name="Phototype_seq",sequenceName="Phototype_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Phototype_seq")
    @Column(name="Phototype_ID",unique = true, nullable = false)

    private @NonNull Long id;
    private @NonNull String name;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Phototype(){}


    public Phototype(String name){
        this.name=name;
    }
}
