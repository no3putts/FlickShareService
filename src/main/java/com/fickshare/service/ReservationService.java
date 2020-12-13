package com.fickshare.service;

import com.fickshare.domain.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    Optional<Reservation> findOne(long resId);
    Reservation reserveMovie(String imdbId, String user);
    Reservation updateReservation(Reservation r);
    void deleteReservation(long resId);
    List<Reservation> findReservationByUser(long userId);
}
