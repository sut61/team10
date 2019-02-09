package com.example.demo.Entity;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.*;
import java.util.Date;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Table(name ="Reservationequipment")
public class Reservationequipment {
    public Long getReservationequipment_id() {
        return Reservationequipment_id;
    }

    //@Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @SequenceGenerator(name="Reservationequipment_seq",sequenceName="Reservationequipment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Reservationequipment_seq")
    @Column(name = "Reservationequipment_ID")
    @Id private @NotNull Long Reservationequipment_id;
    @NotNull
    private  Date Daterent;

    @NotNull
    @Column(unique = true)
    @Pattern(regexp = "[0-9]{13}")
    @Size(min = 13,max=13)
    private String cardid;


    @NotNull
    private  String detail_equipment;

    public String getDetail_equipment() {
        return detail_equipment;
    }

    public void setDetail_equipment(String detail_equipment) {
        this.detail_equipment = detail_equipment;
    }


    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }








    public Long Reservationequipment_id() {
        return Reservationequipment_id;
    }

    public void Reservationequipment_id(Long Reservationequipment_id) {
        this.Reservationequipment_id = Reservationequipment_id;
    }



    public void setDaterent(Date Daterent) {
        this.Daterent = Daterent;
    }




    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Equipment.class)
    @JoinColumn(name = "Equipment_ID", insertable = true)
    private  Equipment equipment;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name = "Member_ID", insertable = true)
    private  Member member;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Timereceive.class)
    @JoinColumn(name = "Timereceive_ID", insertable = true)
    private Timereceive timereceive;

    public Member getMember(){
        return  member;
    }
    public void setMember(Member member){
        this.member =member;
    }


    public Timereceive getTimereceive(){
        return timereceive;
    }
    public void setTimereceive(Timereceive timereceive){
        this.timereceive = timereceive;
    }

    public Equipment getEquipment(){
        return  equipment;
    }
    public void setEquipment(Equipment equipment){
        this.equipment =equipment;
    }


    public Reservationequipment(){}
    public Reservationequipment(Date Daterent ,String cardid,String detail_equipment, Member member, Equipment equipment, Timereceive timereceive){
        this.cardid = cardid;
        this.detail_equipment = detail_equipment;
        this.Daterent = Daterent;
        this.member =member;
        this.timereceive = timereceive;
        this.equipment = equipment;
    }

    public Date getDaterent() {
        return Daterent;
    }
}