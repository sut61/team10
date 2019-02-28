package com.example.demo.Entity;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Data
@Table(name="PromotionTable")
public class PromotionTable {
    @Id
    @SequenceGenerator(name="proT_seq",sequenceName="proT_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="proT_seq")
    @Column(name = "PromotionTableId" )
    private @NotNull Long id;
    private @NotNull String promotionnametable;
    private @Positive int Price;

    public String getPromotionName() { return promotionnametable; }
    public void setPromotionName(String promotionName) { this.promotionnametable = promotionName; }
    public int getPrice() { return Price; }
    public void setPrice(int price) { this.Price = price; }

    public PromotionTable(String promotionName, int price) {
        this.promotionnametable = promotionName;
        this.Price = price; }
    public PromotionTable(){}
}
