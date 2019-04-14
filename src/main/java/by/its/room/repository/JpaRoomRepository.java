package by.its.room.repository;

import by.its.room.model.Room;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaRoomRepository implements RoomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveRoom(Room room) {
        entityManager.persist(room);
    }

    @Override
    public Room findRoomById(Long id) {
        return entityManager.find(Room.class, id);
    }

    @Override
    public List<Room> allListRooms() {
        return entityManager.createNamedQuery("Room.findAllRoom", Room.class).getResultList();
    }

    @Override
    public void updateRoom(Room room) {
        entityManager.merge(room);
    }
}
