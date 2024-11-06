package com.scaler.lldjun24.parkinglot.repositories;

import com.scaler.lldjun24.parkinglot.models.ParkingLot;
import com.scaler.lldjun24.parkinglot.models.ParkingSpot;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ParkingLotRepository {
    private Map<Long, ParkingLot> parkingLotMap = new HashMap<>();

    public Optional<ParkingLot> getParkingLotByGateId(Long GateId)
    {
        Optional<ParkingLot> optionalParkingLot = Optional.ofNullable(parkingLotMap.get(GateId));
        return  optionalParkingLot;


    }
}
