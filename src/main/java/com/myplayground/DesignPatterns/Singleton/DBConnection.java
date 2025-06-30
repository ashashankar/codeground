package com.myplayground.DesignPatterns.Singleton;

public class DBConnection {

    private static DBConnection dbConnection = null;
    private DBConnection() {
    }

    public static DBConnection getInstance() {

        if (dbConnection == null) {
            synchronized (DBConnection.class) {
                if (dbConnection == null) {

                    dbConnection = new DBConnection();
                }
            }

        }
        return dbConnection;
    }
}
