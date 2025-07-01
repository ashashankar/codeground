package com.myplayground.DesignPatterns.Decorator;


public class EmailNotificationService implements NotificationService {

    @Override
    public void send(String msg) {
        System.out.println("Notified customer via email " + msg);
    }
}
