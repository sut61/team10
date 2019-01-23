package com.example.demo.Entity;
import lombok.Data;
import lombok.NonNull;
import org.springframework.ui.context.Theme;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="ReservationModel")
public class ReservationModel {
    @Id
    @SequenceGenerator(name="Res_seq",sequenceName="Res_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Res_seq")
    @Column(name = "ReservationModelId" )
    private @NonNull Long id;
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


    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Member.class)
    @JoinColumn(name= "MemberId",insertable = true)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Model.class)
    @JoinColumn(name= "ModelId",insertable = true)
    private Model model;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = PromotionModel.class)
    @JoinColumn(name= "PromotionId",insertable = true)
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
