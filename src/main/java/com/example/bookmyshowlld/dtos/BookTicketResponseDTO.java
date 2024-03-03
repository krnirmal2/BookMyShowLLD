package com.example.bookmyshowlld.dtos;

import lombok.Getter;
import lombok.Setter;


//services not used dto because multiple controllers wants to use same services
// so it will prolem to handle the exception and errror
//1. used dtos because  multiple parameters need to handle which is being wrapped by
// request dto
// 2. response dtos used we only provide the user the required details
// for safety and security purposes

@Getter
@Setter
public class BookTicketResponseDTO {
    private  Long ticketId;
    // Two main fetaures of DTOs that
    // should be Status code and status message
    // we have to handle the exception and give some user freindly

//    private  ResponseStatus status;
    private  String status;

    private  String message;
}
