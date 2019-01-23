package com.example.demo.Entity;
import lombok.*;
import javax.persistence.*;

@Entity
public class TypePhoto {


    @Id
    @SequenceGenerator(name="typephoto_seq",sequenceName="typephoto_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="typephoto_seq")
    private @NonNull Long typephoto_id;
    private @NonNull String typephoto_name;

    public TypePhoto(String typephoto_name){
        this.typephoto_name = typephoto_name;
    }

    public Long getTypephoto_id() { return typephoto_id; }
    public void setTypephoto_id(Long typephoto_id) { this.typephoto_id = typephoto_id; }
    public String getTypephoto_name() { return typephoto_name; }
    public void setTypephoto_name(String typephoto_name) { this.typephoto_name = typephoto_name; }

    public TypePhoto (){}


}
