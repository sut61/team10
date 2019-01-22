package com.example.demo.Entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Table(name ="Typeequipment")
public class Typeequipment {
    @Id
    @SequenceGenerator(name = "typeequipment_seq", sequenceName = "typeequipment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typeequipment_seq")
    @Column(name = "Typeequipment_id", unique = true, nullable = false)
    private @NonNull
    Long Typeequipment_id;

    private String Typeequipment_name;


    public Long getId() {
        return Typeequipment_id;
    }
    public void setId(Long typeequipment_id) {
        this.Typeequipment_id = typeequipment_id;
    }


    public String getTypeequipment_name() {
        return Typeequipment_name;
    }

    public void setTypeequipment_name(String Typeequipment_name) {
        this.Typeequipment_name = Typeequipment_name;
    }



    public Typeequipment() {
    }

    public Typeequipment( String Typeequipment_name) {  //constructor

        this.Typeequipment_name = Typeequipment_name;

    }
}


