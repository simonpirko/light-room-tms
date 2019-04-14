package by.its.room.repository;

import by.its.room.model.Room;

import java.util.List;

public interface RoomRepository {
    void saveRoom(Room room);
    Room findRoomById(Long id);
    List<Room> allListRooms();
    void updateRoom(Room room);
}
