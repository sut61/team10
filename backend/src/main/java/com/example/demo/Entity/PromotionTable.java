package com.example.demo.Entity;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name="PromotionTable")
public class PromotionTable {
    @Id
    @SequenceGenerator(name="proT_seq",sequenceName="proT_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="proT_seq")
    @Column(name = "PromotionTableId" )
    private Long id;
    private  String PromotionName;
    private  int Price;

    public String getPromotionName() { return PromotionName; }
    public void setPromotionName(String promotionName) { this.PromotionName = promotionName; }
    public int getPrice() { return Price; }
    public void setPrice(int price) { this.Price = price; }

    public PromotionTable(String promotionName, int price) {
        this.PromotionName = promotionName;
        this.Price = price; }
    public PromotionTable(){}
}
