package com.myplayground.LLD.ParkingLot.Vehicle;

public abstract class Vehicle {
    String licensePlate;
    VehicleType vehicleType;

    Vehicle(String licensePlate, VehicleType vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

}
