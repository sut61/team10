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
    public String getKeyt() {
        return keyt;
    }

    public void setKeyt(String keyt) {
        this.keyt = keyt;
    }

    private String keyt;

    public TypePhoto(String typephoto_name,String keyt){
        this.typephoto_name = typephoto_name;
        this.keyt=keyt;
    }

    public Long getTypephoto_id() { return typephoto_id; }
    public void setTypephoto_id(Long typephoto_id) { this.typephoto_id = typephoto_id; }
    public String getTypephoto_name() { return typephoto_name; }
    public void setTypephoto_name(String typephoto_name) { this.typephoto_name = typephoto_name; }

    public TypePhoto (){}


}
