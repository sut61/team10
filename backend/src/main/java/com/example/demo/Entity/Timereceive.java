package com.example.demo.Entity;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Table(name ="Timereceive")
public class Timereceive {
    @Id
    @SequenceGenerator(name = "timereceive_seq", sequenceName = "timereceive_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timereceive_seq")
    @Column(name = "Timereceive_id", unique = true, nullable = false)
    private @NonNull Long Timereceive_id;

    private String Timereceive_name;


    public Long getId() {
        return Timereceive_id;
    }
    public void setId(Long timereceive_id) {
        this.Timereceive_id = timereceive_id;
    }


    public String getTimereceive_name() {
        return Timereceive_name;
    }

    public void setTimereceive_name(String Timereceive_name) {
        this.Timereceive_name = Timereceive_name;
    }


    // @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    // private List<Payment> payments = new ArrayList<>();


    public Timereceive() {
    }

    public Timereceive(String Timereceive_name) {  //constructor

        this.Timereceive_name = Timereceive_name;

    }
}

