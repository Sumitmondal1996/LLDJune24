package com.scaler.lldjun24.parkinglot.models;

import java.util.List;

public class ParkingSpot extends BaseModel{
    private int parkingspotnumber;
    private ParkingSpotStatus parkingSpotStatus;
    private List<VehicleType> vehicleTypeList;

    public int getParkingspotnumber() {
        return parkingspotnumber;
    }

    public void setParkingspotnumber(int parkingspotnumber) {
        this.parkingspotnumber = parkingspotnumber;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public List<VehicleType> getVehicleTypeList() {
        return vehicleTypeList;
    }

    public void setVehicleTypeList(List<VehicleType> vehicleTypeList) {
        this.vehicleTypeList = vehicleTypeList;
    }
}
