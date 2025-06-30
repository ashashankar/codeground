package com.myplayground.DesignPatterns.Observer;

import org.springframework.context.ApplicationEvent;

import java.util.List;

public class ItemRestockedEvent extends ApplicationEvent {
    private final String itemName;
    private final List<Customer> subscribers;
    public ItemRestockedEvent(Object source, String itemName, List<Customer> subscribers) {
        super(source);
        this.itemName = itemName;
        this.subscribers = subscribers;
    }

    public String getItemName() {
        return itemName;
    }

    public List<Customer> getSubscribers() {
        return subscribers;
    }
}
