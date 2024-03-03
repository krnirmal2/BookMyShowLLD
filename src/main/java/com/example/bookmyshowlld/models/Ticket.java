package com.example.bookmyshowlld.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    private Date bookingTime;

    // realtionship with Ticket with payments
    // so one ticket have multiple payments
    @OneToMany(mappedBy = "ticket")
    private List<Payment> payments;


    // relationship between seatInshow and ticket
    // one tickets have multiples seats in a show
    @OneToMany(mappedBy = "ticket")
    private List<SeatInShow> seats;

    // relationship with ticket and user
    // ticket book by which user
    @ManyToOne
    private User bookBy;

   


}
