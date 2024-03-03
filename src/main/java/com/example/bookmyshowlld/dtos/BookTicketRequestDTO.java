package com.example.bookmyshowlld.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class BookTicketRequestDTO {
    private List<Long> showSeatsIds ;
    private Long userId;

}
