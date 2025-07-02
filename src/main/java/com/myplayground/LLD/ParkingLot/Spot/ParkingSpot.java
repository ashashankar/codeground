package com.myplayground.LLD.ParkingLot.Spot;

import com.myplayground.LLD.ParkingLot.Vehicle.Vehicle;

public abstract class ParkingSpot {
    final String spotId;
    ParkingSpotType spotType;
    boolean isOccupied;
    Vehicle vehicle;
    ParkingSpot(String spotId) {
        isOccupied = false;
        this.spotId = spotId;
    }

    public synchronized boolean isAvailable() {
        return isOccupied;
    }

    public synchronized boolean assignVehicle(Vehicle vehicle) {
        if (isOccupied) return false;

        isOccupied = true;
        this.vehicle = vehicle;
        return true;
    }
}
