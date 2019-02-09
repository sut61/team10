package com.example.demo.Entity;
import lombok.Data;
import lombok.NonNull;
import org.springframework.ui.context.Theme;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
@Entity
@Data
@Table(name="TablePhotographer")

public class TablePhotographer {
    @Id
    @SequenceGenerator(name="TableP_seq",sequenceName="TableP_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TableP_seq")
    @Column(name = "TablePhotographerId" )
    private Long id;
    @NotNull
    @Pattern(regexp = "^([ก-ู]|[เ-์])+")
    @Size(min = 5 ,max = 20)
    @Column(unique = true)
    private String Location;

    @NotNull
    @Pattern(regexp = "[0-9]{10}")
    private String tel;

    @Temporal(TemporalType.DATE)
    private @io.micrometer.core.lang.NonNull  Date date;

    @NotNull
    @ManyToOne
    private Admin admin ;
    @NotNull
    @ManyToOne
    private TimesPhotogarpher timesPhotogarpher ;
    @NotNull
    @ManyToOne
    private PromotionTable promotionTable ;
    @NotNull
    @ManyToOne
    private Photographer photographer ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @NotNull
    @ManyToOne
    private TypePhoto typePhoto;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public TimesPhotogarpher getTimesPhotogarpher() { return timesPhotogarpher; }
    public void setTimesPhotogarpher(TimesPhotogarpher timesPhotogarpher) { this.timesPhotogarpher = timesPhotogarpher; }
    public PromotionTable getPromotionTable() { return promotionTable; }
    public void setPromotionTable(PromotionTable promotionTable) { this.promotionTable = promotionTable; }
    public Photographer getPhotographer() { return photographer; }
    public void setPhotographer(Photographer photographer) { this.photographer = photographer; }
    public TypePhoto getTypePhoto() { return typePhoto; }
    public void setTypePhoto(TypePhoto typePhoto) { this.typePhoto = typePhoto; }
    public void setLocation(String location) { this.Location = location; }
    public void setTel(String tel) { this.tel = tel; }

    public String getLocation() { return Location; }
    public String getTel() { return tel; }



    public TablePhotographer(String location, String tel, Date date,Admin admin,
                             TimesPhotogarpher timesPhotogarpher, PromotionTable promotionTable, Photographer photographer, TypePhoto typePhoto) {
        this.Location = location;
        this.tel = tel;
        this.date = date;
        this.admin = admin;
        this.timesPhotogarpher = timesPhotogarpher;
        this.promotionTable = promotionTable;
        this.photographer = photographer;
        this.typePhoto = typePhoto;
    }
    public TablePhotographer(){}
}
