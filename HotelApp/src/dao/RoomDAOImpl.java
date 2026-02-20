package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import model.RoomDTO;

public class RoomDAOImpl implements RoomDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/hotel_db";
    private static final String USER = "root";
    private static final String PASS = "ver_so@exp00";

    @Override
    public void addRoom(RoomDTO room) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASS);

            String sql = "INSERT INTO rooms (room_type, price, status) VALUES (?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, room.getRoomType());
            pst.setDouble(2, room.getPrice());
            pst.setString(3, room.getStatus());

            pst.executeUpdate();

            con.close();

            System.out.println("Room added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
public List<RoomDTO> getAllRooms() {

    List<RoomDTO> list = new java.util.ArrayList<>();

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(URL, USER, PASS);

        String sql = "SELECT * FROM rooms";

        PreparedStatement pst = con.prepareStatement(sql);

        java.sql.ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            RoomDTO room = new RoomDTO(
                    rs.getInt("room_id"),
                    rs.getString("room_type"),
                    rs.getDouble("price"),
                    rs.getString("status")
            );

            list.add(room);
        }

        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}

   @Override
public List<RoomDTO> getAvailableRooms() {

    List<RoomDTO> list = new java.util.ArrayList<>();

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(URL, USER, PASS);

        String sql = "SELECT * FROM rooms WHERE status = 'Available'";

        PreparedStatement pst = con.prepareStatement(sql);

        java.sql.ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            RoomDTO room = new RoomDTO(
                    rs.getInt("room_id"),
                    rs.getString("room_type"),
                    rs.getDouble("price"),
                    rs.getString("status")
            );

            list.add(room);
        }

        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}


   @Override
   public void updateRoomStatus(int roomId, String status) {
   } 
   @Override
   public void deleteRoom(int roomId) {

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(URL, USER, PASS);

        String sql = "DELETE FROM rooms WHERE room_id = ?";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, roomId);

        int rows = pst.executeUpdate();

        if (rows > 0) {
            System.out.println("Room deleted successfully!");
        } else {
            System.out.println("Room not found.");
        }

        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}


   
}


