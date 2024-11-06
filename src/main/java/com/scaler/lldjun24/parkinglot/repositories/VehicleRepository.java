package com.scaler.lldjun24.parkinglot.repositories;

import com.scaler.lldjun24.parkinglot.models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    private Map<String, Vehicle> vehiclemap= new HashMap<>();

    public Vehicle findVehicle(String number)
    {
        Optional<Vehicle> optionalVehicle= Optional.ofNullable(vehiclemap.get(number));
        Vehicle vehicle = optionalVehicle.get();
        return vehicle;


    }

    public Vehicle save(Vehicle vehicle)
    {
        vehiclemap.put(vehicle.getNumber(), vehicle);


        return  vehiclemap.get(vehicle.getNumber());
    }

}
