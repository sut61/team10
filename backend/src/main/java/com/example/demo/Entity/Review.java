package com.example.demo.Entity;

import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity

public class Review {

    public Long getReview_id() { return review_id; }
    public void setReview_id(Long review_id) { this.review_id = review_id; }
    public String getComment_review() { return comment_review; }
    public void setComment_review(String comment_review) { this.comment_review = comment_review; }
    public Review(String comment_review){ this.comment_review = comment_review; }
    public Member getMember() { return member; }
    public void setMember(Member member) { this.member = member; }
    public SystemName getSystemName() { return systemName; }
    public void setSystemName(SystemName systemName) { this.systemName = systemName; }
    public Score getScore() { return score; }
    public void setScore(Score score) { this.score = score; }
    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment) { this.payment = payment; }
    public String getGood_comment() { return good_comment; }
    public void setGood_comment(String good_comment) { this.good_comment = good_comment; }
    public String getDis_comment() { return dis_comment; }
    public void setDis_comment(String dis_comment) { this.dis_comment = dis_comment; }
    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }
    public Long getDirection() { return Direction; }
    public void setDirection(Long direction) { Direction = direction; }


    @Id
    @SequenceGenerator(name="review_seq",sequenceName="review_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="review_seq")
    private @NonNull Long review_id;


    @NotNull
    private String comment_review;

    @NotNull
    @Pattern(regexp = "^([\\u0E00-\\u0E7F0-9])+")
    @Size(min = 5 ,max = 20)
    private String topic;

    @NotNull
    private String good_comment;

    @NotNull
    private String dis_comment;

    @NotNull
    @Positive
    private Long Direction;



    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name = "Member_ID", insertable = true)
    private Member member;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = SystemName.class)
    @JoinColumn(name = "SystemStudio_ID", insertable = true)
    private SystemName systemName;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Score.class)
    @JoinColumn(name = "Score_ID", insertable = true)
    private Score score;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Payment.class)
    @JoinColumn(name = "Payment_ID", insertable = true)
    private Payment payment;

    public Review(){}

    public Review(Member member,String topic,Payment payment,SystemName systemName,Score score,String good_comment
            ,String dis_comment,String comment_review,Long direction){
        this.member = member;
        this.topic = topic;
        this.payment = payment;
        this.systemName = systemName;
        this.score = score;
        this.good_comment = good_comment;
        this.dis_comment = dis_comment;
        this.comment_review = comment_review;
        this.Direction = direction;

    }


}

