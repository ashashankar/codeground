package com.myplayground.DesignPatterns.Observer;


public class Observer_driver {
    static InventoryService_Publisher publisher = new InventoryService_Publisher();

    public static void main(String[] args) {
        Customer alice = new Customer("Alice", "789221000", new EmailNotificationStrategy("alice@alice.com", "Iphone18"));

        Customer bob = new Customer("Bob", "2292002111", new SMSNotificationStrategy("2292002111", "Brooks Ghost"));
        publisher.registerInterest("Iphone18", alice);
        publisher.registerInterest("Brooks Ghost", bob);

        publisher.addInventory("Iphone18");

    }
}
