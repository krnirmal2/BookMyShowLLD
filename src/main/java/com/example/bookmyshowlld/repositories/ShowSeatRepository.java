package com.example.bookmyshowlld.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.bookmyshowlld.models.SeatInShow;

@Repository
public class ShowSeatRepository {

    public SeatInShow save(SeatInShow seat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    public static List<SeatInShow> findByIds(List<Long> showSeatIds) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByIds'");
    }
}
