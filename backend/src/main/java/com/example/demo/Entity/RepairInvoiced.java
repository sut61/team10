package com.example.demo.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RepairInvoiced {
    @Id
    @SequenceGenerator(name="rep_seq",sequenceName="rep_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="rep_seq")
    private  Long id;

    @ManyToOne
    private Comment comment ;

    @ManyToOne
    private Equipment equipment;

    public RepairInvoiced (){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Date getDatein() {
        return datein;
    }

    public void setDatein(Date datein) {
        this.datein = datein;
    }

    @ManyToOne
    private Admin admin ;

    @Temporal(TemporalType.DATE)
    private @io.micrometer.core.lang.NonNull
    Date datein ;
}
