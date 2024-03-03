package com.example.bookmyshowlld.services;

import com.example.bookmyshowlld.exceptions.ShowSeatNotAvailableException;
import com.example.bookmyshowlld.exceptions.UserNotFoundException;
import com.example.bookmyshowlld.models.SeatInShow;
import com.example.bookmyshowlld.models.Ticket;
import com.example.bookmyshowlld.models.User;
import com.example.bookmyshowlld.models.enums.SeatStatus;
import com.example.bookmyshowlld.repositories.ShowSeatRepository;
import com.example.bookmyshowlld.repositories.TicketRepository;
import com.example.bookmyshowlld.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {
    private ShowSeatRepository showSeatRepository;
    private TicketRepository ticketRepository;
    private UserRepository userRepository;

    @Autowired //before use the autowired we have to decorate the
    // corresponding repository with @Repository annotation
    public TicketService(ShowSeatRepository showSeatRepository, TicketRepository ticketRepository, UserRepository userRepository) {
        this.showSeatRepository = showSeatRepository;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }



    public Ticket bookTicket(List<Long> showSeatIds, Long userId) throws ShowSeatNotAvailableException, UserNotFoundException {
        //Algorithm implementation
        // 1. Get showseats for selected Ids
        List<SeatInShow> selectedSeats = ShowSeatRepository.findByIds(showSeatIds);
        // now check by looping the that which are available
        for(SeatInShow seat : selectedSeats){
            if(isSeatAvailable(seat) == false){
                // problems then we have to send error if seat not available
                throw new ShowSeatNotAvailableException();
            }
        }
        User bookedBy = userRepository.findUserBy(userId);
        if(bookedBy == null){
            throw new UserNotFoundException();
        }

        List<SeatInShow> selectedUpdatedSeats = new ArrayList<>();
        for(SeatInShow seat : selectedSeats){
            // updated in the
            seat.setSeatStatus(SeatStatus.LOCKED);
            seat.setStatusUpdatedAt(new Date());

            //now update the repository

            seat = showSeatRepository.save(seat);
            selectedUpdatedSeats.add(seat);
        }

        // 2. check if they are available (available or locked in 10 min ago)
        // 3. if not available , send back with an exception
        // 4. Else, lock them
        // 5. prepare dummy ticket
        Ticket ticket = new Ticket();
        // ticket.setBookedBy(bookedBy);
        // ticket.getBookingTime(new Date());
        // ticket.setSeats(selectedUpdatedSeats);
        // ticket = ticketRepository.save(ticket);

        //  6. return ticket
        return new Ticket();
    }

    private boolean isSeatAvailable(SeatInShow seat) {
        if(seat.getSeatStatus()== SeatStatus.AVAILABLE){
            return true;
        }
        else if(seat.getSeatStatus() == SeatStatus.LOCKED){
            Long lockedAt = seat.getStatusUpdatedAt().getTime();
            Long currentTime = System.currentTimeMillis();

            // Duration
            Long duration = currentTime - lockedAt;
            Long durationInSeconds = duration/1000;
            Long durationInMinutes = durationInSeconds/60;
            if(durationInMinutes>= 10){
                return  true;
            }

        }
        return false;
    }
}
