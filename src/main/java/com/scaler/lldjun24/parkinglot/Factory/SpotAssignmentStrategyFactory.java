package com.scaler.lldjun24.parkinglot.Factory;

import com.scaler.lldjun24.parkinglot.models.SpotAssigningStrategy;
import com.scaler.lldjun24.parkinglot.strategy.spotassignmentstrategy.CheapestSpotAssignmentStrategy;
import com.scaler.lldjun24.parkinglot.strategy.spotassignmentstrategy.NeartoElevatorStrategy;
import com.scaler.lldjun24.parkinglot.strategy.spotassignmentstrategy.RandomSpotAssigningStrategy;
import com.scaler.lldjun24.parkinglot.strategy.spotassignmentstrategy.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {

    public static SpotAssignmentStrategy getSpotAssignmentStrategy(SpotAssigningStrategy spotAssigningStrategy)
    {
        if(spotAssigningStrategy.equals(SpotAssigningStrategy.CHEAPEST))
        {
            return new CheapestSpotAssignmentStrategy();
        }
        if(spotAssigningStrategy.equals(SpotAssigningStrategy.NEAREST_TO_ELEVATOR))
        {
            return new NeartoElevatorStrategy();
        }
        return new RandomSpotAssigningStrategy();
    }
}
