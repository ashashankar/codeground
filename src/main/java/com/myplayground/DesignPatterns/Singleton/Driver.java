package com.myplayground.DesignPatterns.Singleton;

public class Driver {
    public static void main(String[] args) {
        Runnable task = () -> {
            DBConnection dbConnection = DBConnection.getInstance();
            if (dbConnection == null) {
                System.out.println(" partial obtained "+ dbConnection);
            } else {
                System.out.println(" successfully obtained "+ dbConnection);
            }
        };

        for (int i=1; i<=10000; i++) {
            new Thread(task).start();
        }
    }
}
