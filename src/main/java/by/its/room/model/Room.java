package by.its.room.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "room")
@NamedQueries({
        @NamedQuery(name = "Room.findAllRoom", query = "select r from Room r")
})
public class Room {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Bulb bulb;
}
