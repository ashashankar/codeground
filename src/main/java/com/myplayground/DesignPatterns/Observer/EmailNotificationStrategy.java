package com.myplayground.DesignPatterns.Observer;

public class EmailNotificationStrategy implements NotificationStrategy {
    String email;
    String item ;
    EmailNotificationStrategy(String email, String item) {
        this.email = email;
        this.item = item;
    }
    @Override
    public void notifyCustomer() {
        System.out.println(" Sending customer an email" + email+" for item "+ item);
    }
}
