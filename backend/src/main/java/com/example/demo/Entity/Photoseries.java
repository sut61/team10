package com.example.demo.Entity;

import io.micrometer.core.lang.NonNull;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Table(name="Photoseries")
public class Photoseries {
    @Id
    @SequenceGenerator(name="Photoseries_seq",sequenceName="Photoseries_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Photoseries_seq")
    @Column(name="Photoseries_ID",unique = true, nullable = false)
    private @NonNull Long id;
    private @NonNull String name;

    public Long getId() { return id; }

    public void setId(Long id){ this.id=id; }

    public String getName(){ return name; }

    public void setName(String name) { this.name = name; }

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "photoseries",
            cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Photocollection> photocollection ;

    public Photoseries(){}

    public Photoseries(String name){
        this.name=name;
    }




}
