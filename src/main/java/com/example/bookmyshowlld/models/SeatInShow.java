package com.example.bookmyshowlld.models;

import com.example.bookmyshowlld.models.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity // for each model have id in dob
public class SeatInShow extends BaseModel{
    private SeatStatus seatStatus;

    // relationship seatInshow with seat status
    // one seatInshow associated with one seat with some status
    // but one seat can be asscociated with many show
//    @Enumerated(EnumType.ORDINAL)
//    private SeatStatus seatStatus;

    @ManyToOne
    private Seat seat;

    @ManyToOne
    private Ticket ticket;

    // as one show have many show
    @ManyToOne
    private MovieShow show;
    private Date statusUpdatedAt;

}
