package com.example.demo.Entity;
import lombok.Data;
import lombok.NonNull;
import javax.persistence.*;

@Entity
@Data
@Table(name="PromotionModel")
public class PromotionModel {
    @Id
    @SequenceGenerator(name="Pro_seq",sequenceName="Pro_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Pro_seq")
    @Column(name = "PromotionId" )
    private @NonNull Long id;
    private @NonNull String promotionnamemodel;
    private @NonNull int Price;

    public void setPromotionName(String PromotionName){this.promotionnamemodel=PromotionName;}
    public String getPromotionName(){return promotionnamemodel;}
    public void setPrice(int Price) { this.Price = Price; }
    public int getPrice(){return Price;}

    public PromotionModel(){}
    public PromotionModel(String PromotionName,int Price){
        this.promotionnamemodel=PromotionName;
        this.Price=Price;
    }
}
