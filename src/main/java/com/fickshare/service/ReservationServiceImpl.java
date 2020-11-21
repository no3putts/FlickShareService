package com.fickshare.service;

import com.fickshare.domain.Reservation;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Override
    public Reservation findOne(long resId) {
        return null;
    }

    @Override
    public Reservation reserveMovie(Reservation r) {
        return null;
    }

    @Override
    public Reservation updateReservation(Reservation r) {
        return null;
    }

    @Override
    public int deleteReservation(long resId) {
        return 0;
    }
}
