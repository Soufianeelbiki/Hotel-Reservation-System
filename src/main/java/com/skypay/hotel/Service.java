 package com.skypay.hotel;
  
  import java.time.LocalDate;
  import java.util.ArrayList;
  import java.util.Date;
  import java.util.List;
  
  /**
   * Service managing rooms, users and bookings using ArrayLists.
   */
  public class Service {
      private final List<Room> rooms = new ArrayList<>();
      private final List<User> users = new ArrayList<>();
      private final List<Booking> bookings = new ArrayList<>();
  
      public void setRoom(int roomNumber, RoomType type, int pricePerNight) {
          Room room = findRoom(roomNumber);
          if (room == null) {
              rooms.add(new Room(roomNumber, type, pricePerNight));
          } else {
              room.setType(type);
              room.setPricePerNight(pricePerNight);
          }
      }
  
      public void setUser(int userId, int balance) {
          User user = findUser(userId);
          if (user == null) {
              users.add(new User(userId, balance));
          } else {
               // update balance? here skip
          }
      }
  
     public void bookRoom(int userId, int roomNumber, Date in, Date out) {
    LocalDate checkIn = toLocal(in);
    LocalDate checkOut = toLocal(out);

    // 1. Validate input
    if (!checkOut.isAfter(checkIn)) {
        System.out.println("Failed to book: check-out must be after check-in.");
        return;
    }

    User user = findUser(userId);
    Room room = findRoom(roomNumber);
    if (user == null || room == null) {
        System.out.println("Failed to book: user or room not found.");
        return;
    }

    // 2. Calculate cost
    int nights = (int) (checkOut.toEpochDay() - checkIn.toEpochDay());
    int cost = nights * room.getPricePerNight();
    if (user.getBalance() < cost) {
        System.out.println("Failed to book: insufficient balance.");
        return;
    }

    // 3. Check overlapping bookings
    for (Booking b : bookings) {
        if (b.getRoomNumber() == roomNumber &&
            !(checkOut.isBefore(b.getCheckIn()) || checkIn.isAfter(b.getCheckOut()))) {
            System.out.println("Failed to book: room already booked for that period.");
            return;
        }
    }

    // 4. All good: apply booking
    user.debit(cost);
    bookings.add(new Booking(userId, roomNumber, checkIn, checkOut, room.getPricePerNight()));
    System.out.println("Booking successful: User " + userId + " booked Room " + roomNumber);
}

      public void printAll() {
          System.out.println("Rooms (latest to oldest):");
          for (int i = rooms.size()-1; i>=0; i--) System.out.println(rooms.get(i));
          System.out.println("Bookings (latest to oldest):");
          for (int i = bookings.size()-1; i>=0; i--) System.out.println(bookings.get(i));
      }
  
      public void printAllUsers() {
          System.out.println("Users (latest to oldest):");
          for (int i = users.size()-1; i>=0; i--) System.out.println(users.get(i));
      }
  
      private Room findRoom(int num) {
          return rooms.stream().filter(r->r.getRoomNumber()==num).findFirst().orElse(null);
      }
      private User findUser(int id) {
          return users.stream().filter(u->u.getUserId()==id).findFirst().orElse(null);
      }
      private LocalDate toLocal(Date d) {
          return new java.sql.Date(d.getTime()).toLocalDate();
      }
  }