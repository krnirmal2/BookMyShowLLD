package com.example.bookmyshowlld.controllers;

import com.example.bookmyshowlld.dtos.BookTicketRequestDTO;
import com.example.bookmyshowlld.dtos.BookTicketResponseDTO;
import com.example.bookmyshowlld.dtos.ResponseStatus;
import com.example.bookmyshowlld.models.Ticket;
import com.example.bookmyshowlld.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.logging.Logger;
@Controller
public class TicketController {
    // here call the request Dtos and response dtos

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public BookTicketResponseDTO bookTicket(BookTicketRequestDTO requestDTO){
       BookTicketResponseDTO responseDTO = new BookTicketResponseDTO();
        try {
            Ticket ticket = ticketService.bookTicket(requestDTO.getShowSeatsIds(), requestDTO.getUserId());

            responseDTO.setTicketId(Long.valueOf(ticket.getId()));
            responseDTO.setStatus(ResponseStatus.SUCCESS);
            responseDTO.setMessage("Ticket generated successfully");
        }catch (Exception e){
            responseDTO.setStatus(ResponseStatus.FAILURE);

            responseDTO.setMessage("some thing went wrong check this error ");
            Logger.getAnonymousLogger();
        }

        return responseDTO;
    }
}
