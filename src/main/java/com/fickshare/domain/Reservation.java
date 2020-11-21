package com.fickshare.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reservation {
    @Id
    @GeneratedValue
    private long id;

    private long userId;
    private long movieId;
    private String title;
    private Date holdDts;
    private Date checkoutDts;
    private Date returnDts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getHoldDts() {
        return holdDts;
    }

    public void setHoldDts(Date holdDts) {
        this.holdDts = holdDts;
    }

    public Date getCheckoutDts() {
        return checkoutDts;
    }

    public void setCheckoutDts(Date checkoutDts) {
        this.checkoutDts = checkoutDts;
    }

    public Date getReturnDts() {
        return returnDts;
    }

    public void setReturnDts(Date checkinDts) {
        this.returnDts = checkinDts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return getId() == that.getId() &&
                getUserId() == that.getUserId() &&
                getMovieId() == that.getMovieId() &&
                Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getHoldDts(), that.getHoldDts()) &&
                Objects.equals(getCheckoutDts(), that.getCheckoutDts()) &&
                Objects.equals(getReturnDts(), that.getReturnDts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserId(), getMovieId(), getTitle(), getHoldDts(), getCheckoutDts(), getReturnDts());
    }

}
