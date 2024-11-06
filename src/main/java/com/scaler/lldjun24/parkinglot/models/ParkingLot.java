package com.scaler.lldjun24.parkinglot.models;

import java.util.List;

public class ParkingLot extends BaseModel{
    private List<ParkingFloor> parkingFloorList;
    private List<Gate> gateList;
    private String address;
    private List<VehicleType> vehicleTypeList;
    private SpotAssigningStrategy spotAssigningStrategy;

    public List<ParkingFloor> getParkingFloorList() {
        return parkingFloorList;
    }

    public void setParkingFloorList(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
    }

    public List<Gate> getGateList() {
        return gateList;
    }

    public void setGateList(List<Gate> gateList) {
        this.gateList = gateList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<VehicleType> getVehicleTypeList() {
        return vehicleTypeList;
    }

    public void setVehicleTypeList(List<VehicleType> vehicleTypeList) {
        this.vehicleTypeList = vehicleTypeList;
    }

    public SpotAssigningStrategy getSpotAssigningStrategy() {
        return spotAssigningStrategy;
    }

    public void setSpotAssigningStrategy(SpotAssigningStrategy spotAssigningStrategy) {
        this.spotAssigningStrategy = spotAssigningStrategy;
    }
}
