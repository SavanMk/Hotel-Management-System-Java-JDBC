package dao;

import java.util.List;
import model.RoomDTO;

public interface RoomDAO {

    void addRoom(RoomDTO room);

    List<RoomDTO> getAllRooms();

    List<RoomDTO> getAvailableRooms();

    void updateRoomStatus(int roomId, String status);

    void deleteRoom(int roomId);

}
