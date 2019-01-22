package com.example.demo.Entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Table(name ="Equipment")
public class Equipment {
    @Id
    @SequenceGenerator(name = "equipment_seq", sequenceName = "equipment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipment_seq")
    @Column(name = "equipment_id", unique = true, nullable = false)
    private @NonNull Long Equipment_id;
    private String Equipment_name;
    private  int Equipment_price;


    public Long getId() {
        return Equipment_id;
    }

    public void setId(Long equipment_id) {
        this.Equipment_id = equipment_id;
    }


    public String getEquipment_name() {
        return Equipment_name;
    }

    public void setEquipment_name(String Equipment_name) {
        this.Equipment_name = Equipment_name;
    }
    public int getEquipment_price() {
        return Equipment_price;
    }

    public void setEquipment_price(int Equipment_price) {
        this.Equipment_price = Equipment_price;
    }


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Typeequipment.class)
    @JoinColumn(name = "Typeequipment_ID", insertable = true)
    private  Typeequipment typeequipment;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Brandequipment.class)
    @JoinColumn(name = "Brandequipment_ID", insertable = true)
    private Brandequipment brandequipment;

    public Brandequipment getBrandequipment(){
        return  brandequipment;
    }
    public void setBrandequipment(Brandequipment brandequipment){
        this.brandequipment =brandequipment;
    }
    public Typeequipment getTypeequipment(){
        return  typeequipment;
    }
    public void setTypeequipment(Typeequipment typeequipment){
        this.typeequipment =typeequipment;
    }
    public Equipment() {
    }

    public Equipment( String Equipment_name,int Equipment_price,Typeequipment typeequipment,Brandequipment brandequipment) {  //constructor

        this.Equipment_name = Equipment_name;
        this.Equipment_price = Equipment_price;
        this.typeequipment = typeequipment;
        this.brandequipment = brandequipment;
    }
}