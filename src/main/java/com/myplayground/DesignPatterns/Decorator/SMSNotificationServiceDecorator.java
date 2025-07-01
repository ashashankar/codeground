package com.myplayground.DesignPatterns.Decorator;

public class SMSNotificationServiceDecorator extends NotificationServiceDecorator {
    SMSNotificationServiceDecorator(NotificationService service) {
        super(service);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        System.out.println("Sending SMS msg ");
    }
}
