package com.example.demo.Entity;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="TimesPhotogarpher")
public class TimesPhotogarpher {
    @Id
    @SequenceGenerator(name="timesP_seq",sequenceName="timesP_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="timesP_seq")
    @Column(name = "TimesPhotogarpherId" )
    private Long id;
    private String times;

    public String getTimes() { return times; }
    public void setTimes(String times) { this.times = times; }

    public TimesPhotogarpher(String times) { this.times = times; }
    public TimesPhotogarpher(){}
}
