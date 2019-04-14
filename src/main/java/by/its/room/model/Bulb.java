package by.its.room.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bulb")
public class Bulb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "light")
    private boolean light;
}
