package com.scaler.lldjun24.parkinglot.services;

import com.scaler.lldjun24.parkinglot.Factory.SpotAssignmentStrategyFactory;
import com.scaler.lldjun24.parkinglot.exceptions.GateNotFoundException;
import com.scaler.lldjun24.parkinglot.models.*;
import com.scaler.lldjun24.parkinglot.repositories.GateRepositories;
import com.scaler.lldjun24.parkinglot.repositories.ParkingLotRepository;
import com.scaler.lldjun24.parkinglot.repositories.TicketRepository;
import com.scaler.lldjun24.parkinglot.repositories.VehicleRepository;
import com.scaler.lldjun24.parkinglot.strategy.spotassignmentstrategy.SpotAssignmentStrategy;

import java.util.Optional;

public class TicketService {
    private GateRepositories gateRepositories;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;
    public TicketService(GateRepositories gateRepositories, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository)
    {
        this.gateRepositories= gateRepositories;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }
    public Ticket issueticket(Long gateid,  String ownername, String vehiclenumber, VehicleType vehicleType) throws GateNotFoundException //  no need to use dto as dto is only used for client usage
    {
        Ticket ticket = new Ticket();
        Optional<Gate> opt_gate= gateRepositories.findbyId(gateid);
        if(opt_gate.isEmpty())
        {
            throw new GateNotFoundException(gateid);
        }

        Gate gate = opt_gate.get();

        ticket.setGate(gate);
        Vehicle savedvehicle= null;

        Optional<Vehicle> optionalVehicle = Optional.ofNullable(vehicleRepository.findVehicle(vehiclenumber));
        if(optionalVehicle.isEmpty())
        {
            Vehicle vehicle = new Vehicle();
            vehicle.setOwnername(ownername);
            vehicle.setVehicleType(vehicleType);
            vehicle.setNumber(vehiclenumber);
            savedvehicle= vehicleRepository.save(vehicle);
        }
        else {
            savedvehicle= optionalVehicle.get();
        }
        ticket.setVehicle(savedvehicle);

        // Get ParkingLot from GateId:

        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.getParkingLotByGateId(gateid);
        ParkingLot parkingLot = null;
        if(optionalParkingLot.isEmpty())
        {
            throw new RuntimeException("ParkingLotNotFound with the specified GateId");
        }
        else
        {
             parkingLot = optionalParkingLot.get();

        }

        SpotAssigningStrategy spotAssigningStrategy = parkingLot.getSpotAssigningStrategy();
        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentStrategyFactory.getSpotAssignmentStrategy(spotAssigningStrategy);


        ParkingSpot parkingSpot = spotAssignmentStrategy.spot_assignment(vehicleType,gate);
        if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.NOT_AVAILABLE))
        {
            throw new RuntimeException("ParkingSpot not available");
        }

        else
        {
            ticket.setParkingspot(parkingSpot);
        }
        ticketRepository.save(ticket);









        return ticket;
    }
}
