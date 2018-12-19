package com.example.demo.Entity;
import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
@Entity
@Data
@Table(name="ReservationModel")
public class Model {
    @Id
    @Column(name = "ModelId" )
    @SequenceGenerator(name="Mod_seq",sequenceName="Mod_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Mod_seq")
    private @NonNull Long id;
    private @NotNull String ModelName;

    public void setModelName(String ModelName){ this.ModelName=ModelName;}

    public String getModelName() { return ModelName;}

    public Model(){}
    public Model(String ModelName){
        this.ModelName=ModelName;
    }
}
