package com.fickshare.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class MovieStar {
    @Id
    private long id;

    private long starId;

    private long movieId;

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStarId() {
        return starId;
    }

    public void setStarId(long starId) {
        this.starId = starId;
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
        MovieStar movieStar = (MovieStar) o;
        return getId() == movieStar.getId() &&
                getStarId() == movieStar.getStarId() &&
                getMovieId() == movieStar.getMovieId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStarId(), getMovieId());
    }
}
