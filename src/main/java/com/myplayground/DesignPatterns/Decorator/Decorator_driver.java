package com.myplayground.DesignPatterns.Decorator;

public class Decorator_driver {
    public static void main(String[] args) {

        NotificationService service = new NotificationServiceDecorator(new SMSNotificationServiceDecorator(new SlackNotificationServiceDecorator(new EmailNotificationService())));
        service.send("all the best");

    }
}
