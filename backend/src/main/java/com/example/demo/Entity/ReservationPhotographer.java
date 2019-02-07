package com.example.demo.Entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
@Entity
public class ReservationPhotographer {
    @Id
    @SequenceGenerator(name="reservationphotographer_seq",sequenceName="reservationphotographer_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="reservationphotographer_seq")
    private Long reservationphotographer_id;
    @NotNull
    @Pattern(regexp = "^([\\u0E00-\\u0E7F0-9])+")
    @Size(min = 5 ,max = 250)
    private String comment_photo;
    public Date getReservation_date() { return reservation_date; }
    public void setReservation_date(Date reservation_date) { this.reservation_date = reservation_date; }

    @Temporal(TemporalType.DATE)
    private @io.micrometer.core.lang.NonNull
    Date reservation_date;

   @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
   @JoinColumn(name = "Member_ID", insertable = true)
    private Member member;
   @ManyToOne(fetch = FetchType.EAGER, targetEntity = Photographer.class)
   @JoinColumn(name = "Photographer_ID", insertable = true)
   private Photographer photographer;
   @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypePhoto.class)
   @JoinColumn(name = "TypePhoto_ID", insertable = true)
   private TypePhoto typePhoto;
   @ManyToOne(fetch = FetchType.EAGER, targetEntity = PromotionPhotographer.class)
   @JoinColumn(name = "PromotionPhotographer_ID", insertable = true)
   private PromotionPhotographer promotionPhotographer;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = StartTime.class)
    @JoinColumn(name = "StartTime_ID", insertable = true)
    private StartTime startTime;

    public ReservationPhotographer(Member member, Photographer photographer, TypePhoto typePhoto, PromotionPhotographer promotionPhotographer,
                                   StartTime startTime,Date date,String comment_photo){
        this.member = member;
        this.photographer = photographer;
        this.typePhoto = typePhoto;
        this.promotionPhotographer = promotionPhotographer;
        this.startTime = startTime;

        this.reservation_date = date;
        this.comment_photo = comment_photo;
    }
    public Long getReservationphotographer_id() { return reservationphotographer_id; }
    public void setReservationphotographer_id(Long reservationphotographer_id) { this.reservationphotographer_id = reservationphotographer_id; }
    public Member getMember() { return member; }
    public void setMember(Member member) { this.member = member; }
    public Photographer getPhotographer() { return photographer; }
    public void setPhotographer(Photographer photographer) { this.photographer = photographer; }
    public TypePhoto getTypePhoto() { return typePhoto; }
    public void setTypePhoto(TypePhoto typePhoto) { this.typePhoto = typePhoto; }
    public PromotionPhotographer getPromotionPhotographer() { return promotionPhotographer; }
    public void setPromotionPhotographer(PromotionPhotographer promotionPhotographer) { this.promotionPhotographer = promotionPhotographer; }
    public StartTime getStartTime() { return startTime; }
    public void setStartTime(StartTime startTime) { this.startTime = startTime; }
    public String getComment_photo() { return comment_photo; }
    public void setComment_photo(String comment_photo) { this.comment_photo = comment_photo; }


    public ReservationPhotographer(){}


}
