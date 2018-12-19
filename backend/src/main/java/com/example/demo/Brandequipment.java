package com.example.demo.entity;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Table(name ="Brandequipment")
public class Brandequipment {
    @Id
    @SequenceGenerator(name = "brandequipment_seq", sequenceName = "brandequipment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brandequipment_seq")
    @Column(name = "Brandequipment_id", unique = true, nullable = false)
    private @NonNull
    Long Brandequipment_id;

    private String Brandequipment_name;


    public Long getId() {
        return Brandequipment_id;
    }
    public void setId(Long brandequipment_id) {
        this.Brandequipment_id = brandequipment_id;
    }


    public String getBrandequipment_name() {
        return Brandequipment_name;
    }

    public void setBrandequipment_name(String Brandequipment_name) {
        this.Brandequipment_name = Brandequipment_name;
    }


    // @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    // private List<Payment> payments = new ArrayList<>();


    public Brandequipment() {
    }

    public Brandequipment( String Brandequipment_name) {  //constructor

        this.Brandequipment_name = Brandequipment_name;

    }
}

