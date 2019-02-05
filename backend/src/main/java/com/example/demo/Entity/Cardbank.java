package com.example.demo.Entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Table(name ="Cardbank")
public class Cardbank {
    @Id
    @SequenceGenerator(name = "cardbank_seq", sequenceName = "cardbank_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cardbank_seq")
    @Column(name = "cardbank_id", unique = true, nullable = false)
    private @NonNull
    Long Cardbank_id;

    private String Card_bank;


    public Long getId() {
        return Cardbank_id;
    }

    public void setId(Long cardbank_id) {
        this.Cardbank_id = cardbank_id;
    }


    public String getCard_bank() {
        return Card_bank;
    }

    public void setCard_bank(String Card_bank) {
        this.Card_bank = Card_bank;
    }


    // @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    // private List<Payment> payments = new ArrayList<>();


    public Cardbank() {
    }

    public Cardbank( String Card_bank) {  //constructor

        this.Card_bank = Card_bank;

    }
}