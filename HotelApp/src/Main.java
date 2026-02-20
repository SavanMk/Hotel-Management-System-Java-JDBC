import java.util.List;
import java.util.Scanner;

import dao.RoomDAO;
import dao.RoomDAOImpl;
import model.RoomDTO;

public class Main {

    public static void main(String[] args) {

        RoomDAO dao = new RoomDAOImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Room");
            System.out.println("2. View All Rooms");
            System.out.println("3. Update Room Status");
            System.out.println("4. Delete Room");
            System.out.println("5. View Available Rooms");
            System.out.println("6. Exit");


       
    

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();


           switch (choice) {

    case 1:
        System.out.print("Enter Room Type: ");
        String type = sc.next();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        RoomDTO room = new RoomDTO(0, type, price, "Available");
        dao.addRoom(room);
        break;

    case 2:
        List<RoomDTO> rooms = dao.getAllRooms();

        for (RoomDTO r : rooms) {
            System.out.println(
                    r.getRoomId() + " | " +
                    r.getRoomType() + " | " +
                    r.getPrice() + " | " +
                    r.getStatus()
            );
        }
        break;

    case 3:
        System.out.print("Enter Room ID: ");
        int id = sc.nextInt();

        System.out.print("Enter New Status (Available/Occupied): ");
        String newStatus = sc.next();

        dao.updateRoomStatus(id, newStatus);
        break;

    case 4:
        System.out.print("Enter Room ID to delete: ");
        int deleteId = sc.nextInt();
        dao.deleteRoom(deleteId);
        break;

    case 5:
        List<RoomDTO> availableRooms = dao.getAvailableRooms();

        for (RoomDTO r : availableRooms) {
            System.out.println(
                    r.getRoomId() + " | " +
                    r.getRoomType() + " | " +
                    r.getPrice() + " | " +
                    r.getStatus()
            );
        }
        break;

    case 6:
        System.out.println("Exiting...");
        System.exit(0);

    default:
        System.out.println("Invalid choice.");
}

}


               
            }
        }
    


