package com.scaler.lldjun24.parkinglot.models;

import java.util.Date;

public class Ticket extends BaseModel{
    private String number;
    private Date entry_time;
    private Vehicle vehicle;
    private  ParkingSpot parkingspot;
    private Gate gate;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getEntry_time() {
        return entry_time;
    }

    public void setEntry_time(Date entry_time) {
        this.entry_time = entry_time;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingspot() {
        return parkingspot;
    }

    public void setParkingspot(ParkingSpot parkingspot) {
        this.parkingspot = parkingspot;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }
}
