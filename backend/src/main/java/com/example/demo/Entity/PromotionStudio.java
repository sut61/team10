package com.example.demo.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class PromotionStudio {
    @Id
    @SequenceGenerator(name="promotionStudio_seq",sequenceName="promotionStudio_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="promotionStudio_seq")
    private Long id;
    @NotNull private String promotionName;
    @NotNull private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
