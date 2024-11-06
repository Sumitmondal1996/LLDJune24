package com.scaler.lldjun24.parkinglot.repositories;

import com.scaler.lldjun24.parkinglot.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private Map<Long, Ticket> ticketsmap ;
    private static Long id =0L;
    public TicketRepository() {
        ticketsmap= new HashMap<Long, Ticket>();
    }

    public void save(Ticket ticket) {
        ticketsmap.put(id, ticket);
        id++;

    }
}
