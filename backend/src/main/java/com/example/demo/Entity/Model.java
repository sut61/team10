package com.example.demo.Entity;
import lombok.Data;
import lombok.NonNull;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name="Model")
public class Model {
    @Id
    @SequenceGenerator(name="Mol_seq",sequenceName="Mol_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Mol_seq")
    @Column(name = "ModelId" )
    private @NotNull Long id;
    private @NotNull String firstnamemodel;
    private @NotNull String lastnamemodel;


    public void setFirstName(String FirstName) {this.firstnamemodel = FirstName; }
    public String getFirstName() { return firstnamemodel; }
    public void setLastName(String LastName){this.lastnamemodel=LastName;}
    public String getLastName(){return lastnamemodel;}

    public Model(){}
    public Model(String FirstName,String LastName){
        this.firstnamemodel=FirstName;
        this.lastnamemodel=LastName;
    }
}
