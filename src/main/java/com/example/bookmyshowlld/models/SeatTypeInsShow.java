package com.example.bookmyshowlld.models;

import com.example.bookmyshowlld.models.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SeatTypeInsShow extends BaseModel{
    private int price;
//
//    @Enumerated(EnumType.ORDINAL)
//    private SeatType seatType;

    @ManyToOne
    private MovieShow show;
}
