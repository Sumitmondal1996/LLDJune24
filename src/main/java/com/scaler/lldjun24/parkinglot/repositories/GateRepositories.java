package com.scaler.lldjun24.parkinglot.repositories;

import com.scaler.lldjun24.parkinglot.models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepositories {
    private Map<Long, Gate> gateMap= new HashMap<>();
    private Long id;


    public Gate save(Gate gate)
    {
        //Upsert operation
        id = gate.getId();
        if(id==0)
        {
            gate.setId(++id);
            gateMap.put(id, gate);

        }
        gateMap.put(id, gate);
        return gate;
    }

    public Optional<Gate> findbyId(Long Id)
    {
        Optional<Gate> gateOptional = Optional.ofNullable(gateMap.get(Id));
        return gateOptional;

    }
}
