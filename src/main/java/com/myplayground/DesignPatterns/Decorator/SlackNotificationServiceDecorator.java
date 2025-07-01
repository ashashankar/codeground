package com.myplayground.DesignPatterns.Decorator;

public class SlackNotificationServiceDecorator extends NotificationServiceDecorator {


    SlackNotificationServiceDecorator(NotificationService service) {
        super(service);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        System.out.println("Sending Slack msg ");
    }
}
