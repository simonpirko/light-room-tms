package by.its.room.service;

import by.its.room.model.Room;

import java.util.List;

public interface RoomService {
    void addRoom(Room room);
    Room findRoomById(Long id);
    List<Room> allListRooms();
    void lightOn(Long id);
    void lightOff(Long id);
}
