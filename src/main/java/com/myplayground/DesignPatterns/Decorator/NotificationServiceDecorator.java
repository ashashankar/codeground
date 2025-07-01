package com.myplayground.DesignPatterns.Decorator;

public class NotificationServiceDecorator implements NotificationService{
    NotificationService service;
    NotificationServiceDecorator(NotificationService service) {
        this.service = service;
    }
    @Override
    public void send(String msg) {
        this.service.send(msg);
    }
}
