package com.example.demo.Entity;
import lombok.Data;
import lombok.NonNull;
import javax.persistence.*;

@Entity
@Data
@Table(name="Model")
public class Model {
    @Id
    @SequenceGenerator(name="Mol_seq",sequenceName="Mol_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Mol_seq")
    @Column(name = "ModelId" )
    private @NonNull Long id;
    private @NonNull String FirstName;
    private @NonNull String LastName;


    public void setFirstName(String FirstName) {this.FirstName = FirstName; }
    public String getFirstName() { return FirstName; }
    public void setLastName(String LastName){this.LastName=LastName;}
    public String getLastName(){return LastName;}

    public Model(){}
    public Model(String FirstName,String LastName){
        this.FirstName=FirstName;
        this.LastName=LastName;
    }
}
