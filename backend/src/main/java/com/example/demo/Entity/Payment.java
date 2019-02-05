package com.example.demo.Entity;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Null;

import lombok.*;

@Table(name ="Payment")
@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล

public class Payment {
    @SequenceGenerator(name="Payment_seq",sequenceName="Payment_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Payment_seq")
    @Column(name="Payment_ID")
    @Id private @NonNull Long Payment_id;
    private  int Payment_total;
    private  String card_id;
    private   int Card_cvv;
    private   String Card_name;





    public Long getPayment_id() {
        return Payment_id;
    }

    public void setPayment_id(Long Payment_id) {
        this.Payment_id = Payment_id;
    }


    public int getPayment_total() {
        return Payment_total;
    }
    public void setPayment_total(int Payment_total) {
        this.Payment_total = Payment_total;
    }
    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }



    public int getCard_cvv() {
        return Card_cvv;
    }

    public void setCard_cvv(int Card_cvv) {
        this.Card_cvv = Card_cvv;
    }


    public String getCard_name() {
        return Card_name;
    }

    public void setCard_name(String Card_name) {
        this.Card_name = Card_name;
    }


    @ManyToOne

    private  Reservationequipment reservationequipment;

    @ManyToOne
    private Member member;

    @ManyToOne
    private  Cardtype cardtype;

    @ManyToOne
    private  Cardbank cardbank;

    @ManyToOne
    private  Photocollection photocollection;

    @ManyToOne
    private  ReservationModel reservationModel;

    @ManyToOne

    private  ReservationPhotographer reservationPhotographer;

    @ManyToOne
    private  ReservationStudio reservationStudio;

    public Cardbank getCardbank() {
        return cardbank;
    }

    public void setCardbank(Cardbank cardbank) {
        this.cardbank = cardbank;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Reservationequipment getReservationequipment() {
        return reservationequipment;
    }

    public void setReservationequipment(Reservationequipment reservationequipment) {
        this.reservationequipment = reservationequipment;
    }

    public Cardtype getCardtype() {
        return cardtype;
    }

    public void setCardtype(Cardtype cardtype) {
        this.cardtype = cardtype;
    }

    public ReservationModel getReservationModel() {
        return reservationModel;
    }

    public void setReservationModel(ReservationModel reservationModel) {
        this.reservationModel = reservationModel;
    }

    public ReservationStudio getReservationStudio() {
        return reservationStudio;
    }

    public void setReservationStudio(ReservationStudio reservationStudio) {
        this.reservationStudio = reservationStudio;
    }
    public ReservationPhotographer getReservationPhotographer() {
        return reservationPhotographer;
    }

    public void setReservationPhotographer(ReservationPhotographer reservationPhotographer) {
        this.reservationPhotographer = reservationPhotographer;
    }

    public Photocollection getPhotocollection() {
        return photocollection;
    }

    public void setPhotocollection(Photocollection photocollection) {
        this.photocollection = photocollection;
    }
    public Payment() {
    }
    public Payment(int Payment_total, Member member,String card_id,int Card_cvv, String Card_name,
                   Reservationequipment reservationequipment, Cardtype cardtype, Cardbank cardbank,Photocollection photocollection,
                   ReservationPhotographer reservationPhotographer, ReservationStudio reservationStudio, ReservationModel reservationModel)
    {  //constructor

        this.Payment_total = Payment_total;
        this.member = member;
        this.reservationequipment = reservationequipment;
        this.reservationModel = reservationModel;
        this.reservationPhotographer = reservationPhotographer;
        this.reservationStudio = reservationStudio;
        this.photocollection = photocollection;
        this.cardtype = cardtype;
        this.cardbank = cardbank;
        this.card_id = card_id;
        this.Card_cvv = Card_cvv;
        this.Card_name = Card_name;
    }
}
