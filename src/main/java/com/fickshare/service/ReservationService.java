package com.fickshare.service;

import com.fickshare.domain.Reservation;

public interface ReservationService {
    Reservation findOne(long resId);
    Reservation reserveMovie(Reservation r);
    Reservation updateReservation(Reservation r);
    int deleteReservation(long resId);
}
