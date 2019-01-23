package com.example.demo.Entity;
import lombok.*;
import javax.persistence.*;


@Entity
public class Photographer {
    @Id
    @SequenceGenerator(name="photographer_seq",sequenceName="photographer_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="photographer_seq")
    private @NonNull Long photographer_id;
    private @NonNull String photographer_name;
    private @NonNull int photographer_age;
    private @NonNull String photographer_email;
    private @NonNull String photographer_tel;

    public Photographer(String photographer_name, int photographer_age, String photographer_email, String photographer_tel){
        this.photographer_name = photographer_name;
        this.photographer_age = photographer_age;
        this.photographer_email = photographer_email;
        this.photographer_tel = photographer_tel;
    }

    public String getPhotographer_tel() { return photographer_tel; }
    public void setPhotographer_tel(String photographer_tel) { this.photographer_tel = photographer_tel; }
    public Long getPhotographer_id() {
        return photographer_id;
    }
    public void setPhotographer_id(Long photographer_id) {
        this.photographer_id = photographer_id;
    }
    public String getPhotographer_name() { return photographer_name; }
    public void setPhotographer_name(String photographer_name) { this.photographer_name = photographer_name; }
    public int getPhotographer_age() { return photographer_age; }
    public void setPhotographer_age(int photographer_age) { this.photographer_age = photographer_age; }
    public String getPhotographer_email() { return photographer_email; }
    public void setPhotographer_email(String photographer_email) { this.photographer_email = photographer_email; }


    public Photographer(){}



}
