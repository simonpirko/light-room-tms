package by.its.room.service;

import by.its.room.model.Bulb;
import by.its.room.model.Room;
import by.its.room.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JpaRoomService implements RoomService {

    private final RoomRepository roomRepository;

    public JpaRoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void addRoom(Room room) {
        room.setBulb(new Bulb());
        roomRepository.saveRoom(room);
    }

    @Override
    @Transactional(readOnly = true)
    public Room findRoomById(Long id) {
        return roomRepository.findRoomById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Room> allListRooms() {
        return roomRepository.allListRooms();
    }

    @Override
    public void lightOn(Long id) {
        Room roomById = roomRepository.findRoomById(id);
        roomById.getBulb().setLight(true);
        roomRepository.updateRoom(roomById);
    }

    @Override
    public void lightOff(Long id) {
        Room roomById = roomRepository.findRoomById(id);
        roomById.getBulb().setLight(false);
        roomRepository.updateRoom(roomById);
    }
}
