package com.example.demo.Entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Reservation")
public class Reservation {
    @Id
    @SequenceGenerator(name="reservaion_seq",sequenceName="reservaion_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="reservaion_seq")
    @Column(name = "RESERVAION", unique = true, nullable = true)
    private @NonNull Long id;
    private @NonNull String name;

    public void setReservation(String name) {
        this.name = name;
    }
}
