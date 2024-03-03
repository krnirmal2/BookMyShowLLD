package com.example.bookmyshowlld.models;

import com.example.bookmyshowlld.models.enums.SeatType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private String number;
    private String row;
    private String col;

    // Seat related with Auditorium
    // one seat associate with one auditorium
    @ManyToOne
    private Auditorium auditorium;

//    @Enumerated(EnumType.ORDINAL)
//    private SeatType seatType;// SEAT HAS DIFFERENT SEATTYPE


    // RELATIONSHIP WITH SEAT AND SEATINSHOW
    //ONE SEAT IN SHOW WILL BE ASSOCAITED WITH ONE SEAT
    @OneToMany(mappedBy = "seat")
    private List<SeatInShow> seatListInShow;
}
