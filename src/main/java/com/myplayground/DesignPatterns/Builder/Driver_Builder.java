package com.myplayground.DesignPatterns.Builder;

public class Driver_Builder {
    public static void main(String[] args) {
        User user = new User.Builder()
                        .setAge(11)
                        .setName("Ash")
                .setAddress("122")
                .setEmail("ac-b@gmail.com")
                .build();
        System.out.println("User created: " + user);
    }
}
