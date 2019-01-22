package com.example.demo.Entity;
import lombok.*;
import javax.persistence.*;

@Entity
public class PromotionPhotographer {
    @Id
    @SequenceGenerator(name="promotionphoto_seq",sequenceName="promotionphoto_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="pomotionphoto_seq")
    private @NonNull Long promotionphoto_id;
    private @NonNull String promotionphoto_name;
    private @NonNull Long promotion_time;
    private @NonNull Long promotion_price;

    public PromotionPhotographer(String promotionphoto_name, long promotion_time, long promotion_price){
        this.promotionphoto_name = promotionphoto_name;
        this.promotion_time = promotion_time;
        this.promotion_price = promotion_price;
    }

    public Long getPromotion_time() { return promotion_time; }
    public void setPromotion_time(Long promotion_time) { this.promotion_time = promotion_time; }
    public Long getPromotion_price() { return promotion_price; }
    public void setPromotion_price(Long promotion_price) { this.promotion_price = promotion_price; }
    public Long getPromotionphoto_id() { return promotionphoto_id; }
    public void setPromotionphoto_id(Long promotionphoto_id) { this.promotionphoto_id = promotionphoto_id; }
    public String getPromotionphoto_name() { return promotionphoto_name; }
    public void setPromotionphoto_name(String promotionphoto_name) { this.promotionphoto_name = promotionphoto_name; }

    public PromotionPhotographer (){}


}
