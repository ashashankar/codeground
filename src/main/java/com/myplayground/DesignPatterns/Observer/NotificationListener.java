package com.myplayground.DesignPatterns.Observer;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    @EventListener
    public void onItemRestocked(ItemRestockedEvent event) {
        for (Customer c : event.getSubscribers()) {
            c.getNotificationStrategy().notifyCustomer();
        }
    }
}
