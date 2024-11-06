package com.scaler.lldjun24.parkinglot.strategy.spotassignmentstrategy;

import com.scaler.lldjun24.parkinglot.models.Gate;
import com.scaler.lldjun24.parkinglot.models.ParkingSpot;
import com.scaler.lldjun24.parkinglot.models.ParkingSpotStatus;
import com.scaler.lldjun24.parkinglot.models.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot spot_assignment(VehicleType vehicleType, Gate gate);

}
