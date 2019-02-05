package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
@Data
@Entity
public class ReservationStudio {
    public Long getReservationStudio_id() {
        return reservationStudio_id;
    }

    public void setReservationStudio_id(Long reservationStudio_id) {
        this.reservationStudio_id = reservationStudio_id;
    }

    @Id
    @SequenceGenerator(name="reservationStudio_seq",sequenceName="reservationStudio_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="reservationStudio_seq")
    private Long reservationStudio_id;

    private @NotNull int price;

    @Temporal(TemporalType.DATE)
    private @io.micrometer.core.lang.NonNull
    Date reservationDate;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @ManyToOne
    private  Member member ;

    @ManyToOne
    private  PromotionStudio promotionStudio ;

    @ManyToOne
    private  RoomStudio roomStudio;

    @ManyToOne
    private  TimeStudio timeStudio;


    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public PromotionStudio getPromotionStudio() {
        return promotionStudio;
    }
    public void setPromotionStudio(PromotionStudio promotionStudio) {
        this.promotionStudio = promotionStudio;
    }
    public RoomStudio getRoomStudio() {
        return roomStudio;
    }
    public void setRoomStudio(RoomStudio roomStudio) {
        this.roomStudio = roomStudio;
    }
    public TimeStudio getTimeStudio() {
        return timeStudio;
    }
    public void setTimeStudio(TimeStudio timeStudio) {
        this.timeStudio = timeStudio;
    }
    public Date getReservationDate() {
        return reservationDate;
    }
    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

}
