package com.skypay.hotel;

import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws Exception {
        Service svc = new Service();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        // setup rooms
        svc.setRoom(1, RoomType.STANDARD_SUITE,1000);
        svc.setRoom(2, RoomType.JUNIOR_SUITE,2000);
        svc.setRoom(3, RoomType.MASTER_SUITE,3000);
        // setup users with sufficient balance for demo
        svc.setUser(1,5000);
        svc.setUser(2,10000);
        // bookings
        svc.bookRoom(1,2,f.parse("30/06/2026"),f.parse("07/07/2026"));
        svc.bookRoom(1,2,f.parse("07/07/2026"),f.parse("30/06/2026"));
        svc.bookRoom(1,1,f.parse("07/07/2026"),f.parse("08/07/2026"));
        svc.bookRoom(2,1,f.parse("07/07/2026"),f.parse("09/07/2026"));
        svc.bookRoom(2,3,f.parse("07/07/2026"),f.parse("08/07/2026"));
        // update room1
        svc.setRoom(1,RoomType.MASTER_SUITE,10000);
        // print
        svc.printAll();
        svc.printAllUsers();
    }
}