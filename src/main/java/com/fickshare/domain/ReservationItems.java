package com.fickshare.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ReservationItems {
    @Id
    private long id;

    private long reservationId;
    private long movieId;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationItems that = (ReservationItems) o;
        return getId() == that.getId() &&
                getReservationId() == that.getReservationId() &&
                getMovieId() == that.getMovieId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getReservationId(), getMovieId());
    }
}
