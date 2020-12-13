package com.fickshare.service;

import com.fickshare.domain.Movie;
import com.fickshare.domain.Reservation;
import com.fickshare.repo.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepo reservationRepo;
    private MovieService movieService;

    @Autowired
    public  ReservationServiceImpl (ReservationRepo reservationRepo, MovieService movieService){
        this.reservationRepo = reservationRepo;
        this.movieService = movieService;
    }

    @Override
    public Optional<Reservation> findOne(long resId) {
        return reservationRepo.findById(resId);
    }

    @Override
    public Reservation reserveMovie(String imdbId, String user) {

        Movie movie = movieService.getImdbMovie(imdbId);
        Reservation reservation = new Reservation();

        reservation.setImdbId(movie.getImdbID());
        reservation.setUserId(1); // fix to test user

        return reservationRepo.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation r) {
        return reservationRepo.save(r);
    }

    @Override
    public void deleteReservation(long resId) {
        reservationRepo.deleteById(resId);
    }

    @Override
    public List<Reservation> findReservationByUser(long userId) {
        return reservationRepo.findReservationByUserId(userId);
    }
}
