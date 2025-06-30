package com.myplayground.DesignPatterns.Observer;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InventoryService_Publisher {
    ApplicationEventPublisher publisher;
    Map<String, List<Customer>> waitlist = new HashMap<>();
    public InventoryService_Publisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public InventoryService_Publisher() {

    }

    public void registerInterest(String item, Customer customer) {
        waitlist.computeIfAbsent(item, k -> new ArrayList<>()).add(customer);
        System.out.println(customer.getName() + " is waiting for " + item);
    }

    public void addInventory(String item) {
        System.out.println("Restocking item "+ item);
        if (waitlist.containsKey(item)) {
            List<Customer> interested = waitlist.remove(item);
            publisher.publishEvent(new ItemRestockedEvent(this, item, interested));
        }
    }
}
