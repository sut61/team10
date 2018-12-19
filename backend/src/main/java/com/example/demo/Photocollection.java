package th.sut.sa.demo;
import io.micrometer.core.lang.NonNull;
import javax.persistence.*;
import java.util.Date;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Table(name="Photocollection")
public class Photocollection {
    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @SequenceGenerator(name="Photocollection_seq",sequenceName="Photocollection_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Photocollection_seq")
    @Column(name="Photocollection_ID",unique = true, nullable = false)
    private @NonNull Date data;

    public Date getData() { return data; }

    public void setData(Date data) { this.data = data;  }

    public Photocollection(){}

    public Photocollection(Date data){
        this.data=data;
    }

}