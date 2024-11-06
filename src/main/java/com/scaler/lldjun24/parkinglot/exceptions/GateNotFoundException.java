package com.scaler.lldjun24.parkinglot.exceptions;

import com.scaler.lldjun24.parkinglot.repositories.GateRepositories;

public class GateNotFoundException extends Exception{

    public GateNotFoundException(Long id)
    {
        super("Gate with id "+ id+ " not found");


    }
}
