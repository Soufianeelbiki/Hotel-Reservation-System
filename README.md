# 🏨 Hotel Reservation Service

A **simple, in-memory Java app** for managing hotel room bookings — built as a technical test for Skypay. Designed for:

- ✅ **Correctness & Simplicity**
- ⚡ **Performance** (using only `ArrayList`)
- 🔒 **Data Consistency & Integrity**
- 🧹 **Clean Logic/Presentation Separation**
- 🛡️ **Secure Balance & Booking Validation**

---

## ✨ Features

- ➕ **Add/Update Rooms** (type & price)
- 👤 **Register Users** (with initial balance)
- 📅 **Book Rooms** (with checks for availability, balance, and valid dates)
- 💵 **Snapshot Pricing** (price locked at booking time)
- 🚫 **No Overlapping Bookings**
- 🔄 **Reverse-Order Printing** for:
  - Rooms
  - Bookings
  - Users

---

## 🛡️ Security & Data Integrity

- ❌ **No Invalid Operations:** Overdrafts, overlaps, or bad dates are blocked
- ⚙️ **Atomic Bookings:** All-or-nothing, no partial changes
- 🧊 **Immutability:** Each `Booking` captures price & date at booking time
- 💬 **User-Friendly Errors:** All invalid actions return clear messages

---

## 🚀 Getting Started

Clone, build, and run the app in minutes!

```bash
# Clone the repository
git clone https://github.com/Soufianeelbiki/Hotel-Reservation-System.git

# Enter the project directory
cd Hotel-Reservation-System

# Compile the project
mvn clean compile

# Run the demo
mvn exec:java
```

---

## 📁 Project Structure

```
src/
└── main/java/com/skypay/hotel/
        ├── RoomType.java   # Enum: STANDARD_SUITE, etc.
        ├── Room.java       # Room model
        ├── User.java       # User with balance
        ├── Booking.java    # Booking snapshot
        ├── Service.java    # Main logic: create, validate, print
        └── Main.java       # Demo runner with test scenarios
```

---

## 🖥️ Example Output

```
Failed to book: insufficient balance.
Failed to book: check-out must be after check-in.
Booking successful: User 1 booked Room 1
Failed to book: room already booked for that period.
Booking successful: User 2 booked Room 3

Rooms (latest to oldest):

Room 3: MASTER_SUITE @ 3000
Room 2: JUNIOR_SUITE @ 2000
Room 1: MASTER_SUITE @ 10000

Bookings (latest to oldest):

Booking[user=2, room=3, from=2026-07-07, to=2026-07-08, nights=1, price=3000, total=3000]
Booking[user=1, room=1, from=2026-07-07, to=2026-07-08, nights=1, price=1000, total=1000]

Users (latest to oldest):

User 2: balance=7000
User 1: balance=4000
```

---

## 🏗️ Design Highlights

- 🧹 **Clean Code:** Logic centralized in `Service` class
- 🧩 **Separation of Concerns:** Presentation & logic are distinct
- 🛑 **Exception-Safe:** All validation before state changes

---

## 💡 Bonus: Design Reflections

> **Q1: What about putting all logic in one service?**

For a small, self-contained test, a single `Service` class keeps things clear and compact. But in real-world systems, this can become a bottleneck — harder to maintain, debug, or scale.

**For production, consider splitting into:**

- `RoomService` — manage rooms
- `UserService` — handle users & balances
- `BookingService` — validation & reservations

**For this test:** simple & clean.  
**For real-world:** modular & maintainable wins!

---

**Happy coding! 🚀**
