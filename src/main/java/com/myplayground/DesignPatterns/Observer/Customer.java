package com.myplayground.DesignPatterns.Observer;

public class Customer {
    String name;
    String contact;
    private final NotificationStrategy notififcationStrategy;

    public Customer(String name, String contact, NotificationStrategy strategy) {
        this.name = name;
        this.contact = contact;
        this.notififcationStrategy = strategy;
    }

    public String getName() {
        return this.name;
    }

    public String getContact() {
        return this.contact;
    }
    public NotificationStrategy getNotificationStrategy() {
        return this.notififcationStrategy;
    }
}
