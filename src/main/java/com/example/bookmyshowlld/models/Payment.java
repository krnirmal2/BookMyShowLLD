package com.example.bookmyshowlld.models;

import com.example.bookmyshowlld.models.enums.PaymentProvider;
import com.example.bookmyshowlld.models.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private String amt;
    private String transId;
//    private String ticketId;

    //payment status
//    @Enumerated(EnumType.ORDINAL)
//    private PaymentStatus paymentStatus;
//
//    @Enumerated(EnumType.ORDINAL)
//    private PaymentProvider paymentProvider;
//
//    // for one ticket multiple payment can be done
//    // many to one
    @ManyToOne
    @Enumerated(EnumType.ORDINAL)
    private Ticket ticket;


}
