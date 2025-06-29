package com.skypay.hotel;

/**
 * Represents a user with id and balance.
 */
public class User {
    private final int userId;
    private int balance;

    public User(int userId, int balance) {
        this.userId = userId;
        this.balance = balance;
    }

    public int getUserId() { return userId; }
    public int getBalance() { return balance; }

    public void debit(int amount) {
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "User " + userId + ": balance=" + balance;
    }
}