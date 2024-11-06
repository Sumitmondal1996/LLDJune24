package com.scaler.lldjun24.parkinglot.controllers;

import com.scaler.lldjun24.parkinglot.dtos.IssueRequestDto;
import com.scaler.lldjun24.parkinglot.dtos.IssueResponseDto;
import com.scaler.lldjun24.parkinglot.dtos.ResponseStatus;
import com.scaler.lldjun24.parkinglot.models.Ticket;
import com.scaler.lldjun24.parkinglot.services.TicketService;

public class TicketController {
    private TicketService ticketService ;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    public IssueResponseDto issueticket(IssueRequestDto issueRequestDto)
    {
        IssueResponseDto issueResponseDto = new IssueResponseDto();
        try {

            Ticket ticket = ticketService.issueticket(issueRequestDto.getGateid(), issueRequestDto.getNumber(), issueRequestDto.getOwnername(), issueRequestDto.getVehicleType());
            issueResponseDto.setTicket(ticket);
            issueResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e)
        {
            issueResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return  issueResponseDto;
    }
}
