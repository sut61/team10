package com.example.demo.Entity;

import io.micrometer.core.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Table(name="Photopicture")
public class Photopicture {

    @Id
    @SequenceGenerator(name="Photopicture_seq",sequenceName="Photopicture_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Photopicture_seq")
    @Column(name="Photopicture_ID",unique = true, nullable = false)
    private @NonNull Long id;

    @Temporal(TemporalType.DATE)
    private @io.micrometer.core.lang.NonNull
    Date datedata;

    /*@NonNull
    @Pattern(regexp = "^[_A-Za-z0-9]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    @Size(min = 10 ,max = 25)
    @Column(unique = true)*/
    private String dataname;


    public Date getDatedata() { return datedata; }
    public void setDatedata(Date datedata) { this.datedata = datedata; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Photosize.class)
    @JoinColumn(name = "Photosize_ID", insertable = true)
    private Photosize photosize;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Phototype.class)
    @JoinColumn(name = "Phototype_ID", insertable = true)
    private Phototype phototype;

    public Photosize getPhotosize() { return photosize; }

    public void setPhotosize(Photosize photosize) { this.photosize = photosize; }

    public Phototype getPhototype() { return phototype; }

    public void setPhototype(Phototype phototype) { this.phototype = phototype; }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Admin.class)
    @JoinColumn(name = "Admin_ID", insertable = true)
    private Admin admin;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name = "Member_ID", insertable = true)
    private Member member;

    public String getDataname() { return dataname; }
    public void setDataname(String dataname) { this.dataname = dataname; }
    public Date getStartdata() { return datedata; }
    public void setStartdata(Date startdata) { this.datedata = startdata; }



    public Photopicture(){}
    public Photopicture(String dataname,Date datedata){
        this.dataname=dataname;
        this.datedata=datedata;
    }
}
