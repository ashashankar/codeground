package com.myplayground.DesignPatterns.Observer;

public class SMSNotificationStrategy implements NotificationStrategy {

    String contact;
    String item ;
    SMSNotificationStrategy(String ph_no, String item) {
        this.contact = ph_no;
        this.item = item;
    }
    @Override
    public void notifyCustomer() {
        System.out.println(" Notifying customer on phone "+contact+" for item "+ item);
    }
}
