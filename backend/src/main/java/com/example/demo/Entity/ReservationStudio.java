package com.example.demo.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ReservationStudio {
    @Id
    @SequenceGenerator(name="reservationStudio_seq",sequenceName="reservationStudio_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="reservationStudio_seq")
    private Long id;

    @Temporal(TemporalType.DATE)
    private @io.micrometer.core.lang.NonNull
    Date reservationDate;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member ;

    @ManyToOne(fetch = FetchType.LAZY)
    private PromotionStudio promotionStudio ;

    @ManyToOne(fetch = FetchType.LAZY)
    private RoomStudio roomStudio;

    @ManyToOne(fetch = FetchType.LAZY)
    private TimeStudio timeStudio;



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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

//edit
}
