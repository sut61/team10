package com.example.demo.Entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Table(name ="Cardtype")
public class Cardtype {
    @Id
    @SequenceGenerator(name = "cardtype_seq", sequenceName = "cardtype_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cardtype_seq")
    @Column(name = "Cardtype_id", unique = true, nullable = false)
    private @NonNull
    Long Cardtype_id;

    private String Card_type;


    public Long getId() {
        return Cardtype_id;
    }
    public void setId(Long cardtype_id) {
        this.Cardtype_id = cardtype_id;
    }


    public String getCard_type() {
        return Card_type;
    }

    public void setCard_type(String Card_type) {
        this.Card_type = Card_type;
    }


   // @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    // private List<Payment> payments = new ArrayList<>();


    public Cardtype() {
    }

    public Cardtype( String Card_type) {  //constructor

        this.Card_type = Card_type;

    }
}