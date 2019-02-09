package com.example.demo.Entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
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
    private @NotNull Long Equipment_id;
    private @NotNull String Equipment_name;
    private @NotNull String Equipment_type;
    private @NotNull String Equipment_brand;
    private @Positive int Equipment_price;
    private @NotNull String key ;
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }




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

    public String getEquipment_type() {
        return Equipment_type;
    }

    public void setEquipment_type(String Equipment_type) {
        this.Equipment_type = Equipment_type;
    }
    public String getEquipment_brand() {
        return Equipment_brand;
    }

    public void setEquipment_brand(String Equipment_brand) {
        this.Equipment_brand = Equipment_brand;
    }
    public int getEquipment_price() {
        return Equipment_price;
    }

    public void setEquipment_price(int Equipment_price) {
        this.Equipment_price = Equipment_price;
    }





    public Equipment() {
    }

    public Equipment( String Equipment_name,int Equipment_price,String Equipment_type,String Equipment_brand){  //constructor

        this.Equipment_name = Equipment_name;
        this.Equipment_price = Equipment_price;
        this.Equipment_type = Equipment_type;
        this.Equipment_brand = Equipment_brand;
    }
}