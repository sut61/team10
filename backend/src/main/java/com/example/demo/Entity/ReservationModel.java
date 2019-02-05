package com.example.demo.Entity;
import lombok.Data;
import lombok.NonNull;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Date;



@Entity
@Data
@Table(name="ReservationModel")
public class ReservationModel {
    public Long getReservationModel_id() {
        return ReservationModel_id;
    }

    public void setReservationModel_id(Long reservationmodel_id) {
        ReservationModel_id = reservationmodel_id;
    }

    @Id
    @SequenceGenerator(name="ReservationModel_seq",sequenceName="ReservationModel_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ReservationModel_seq")
    @Column(name = "Reservationmodel_ID" )
    private @NonNull Long ReservationModel_id;
    private @NonNull String Themes;
    private @NonNull Date date;
    private  @NonNull String Location;

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public void setThemes(String themes) { this.Themes = themes; }
    public String getThemes() { return Themes; }
    public void setLocation(String location) { this.Location = location; }
    public String getLocation() { return Location; }
    public void setMember(Member member) { this.member = member; }
    public Member getMember() { return member; }
    public void setModel(Model model) { this.model = model; }
    public Model getModel() { return model; }
    public void setPromotionModel(PromotionModel promotionModel) { this.promotionModel = promotionModel; }
    public PromotionModel getPromotionModel() { return promotionModel; }


    @ManyToOne
    private Member member;

    @ManyToOne
    private Model model;

    @ManyToOne
    private PromotionModel promotionModel;


    public ReservationModel(Date date,String themes,String location,Member member, Model model,
                            PromotionModel promotionModel){
        this.Themes=themes;
        this.Location=location;
        this.member=member;
        this.date=date;
        this.model=model;
        this.promotionModel=promotionModel;
    }
    public ReservationModel(){}


}
