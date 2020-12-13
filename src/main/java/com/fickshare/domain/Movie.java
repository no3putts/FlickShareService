package com.fickshare.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie
{
    @Id
    private String imdbID;

    private String title;
    private String year;
    private String rated;
    private String released;
    private String runtime;
    private String genre;
    private String director;
    private String actors;
    private String plot;
    private String language;
    private String country;
    private String poster;
    private String imdbRating;
    private String review;
    private String owner;

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }


    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(getImdbID(), movie.getImdbID()) &&
                Objects.equals(getTitle(), movie.getTitle()) &&
                Objects.equals(getYear(), movie.getYear()) &&
                Objects.equals(getRated(), movie.getRated()) &&
                Objects.equals(getReleased(), movie.getReleased()) &&
                Objects.equals(getRuntime(), movie.getRuntime()) &&
                Objects.equals(getGenre(), movie.getGenre()) &&
                Objects.equals(getDirector(), movie.getDirector()) &&
                Objects.equals(getActors(), movie.getActors()) &&
                Objects.equals(getPlot(), movie.getPlot()) &&
                Objects.equals(getLanguage(), movie.getLanguage()) &&
                Objects.equals(getCountry(), movie.getCountry()) &&
                Objects.equals(getPoster(), movie.getPoster()) &&
                Objects.equals(getImdbRating(), movie.getImdbRating()) &&
                Objects.equals(getOwner(), movie.getOwner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getImdbID(), getTitle(), getYear(), getRated(), getReleased(), getRuntime(), getGenre(), getDirector(), getActors(), getPlot(), getLanguage(), getCountry(), getPoster(), getImdbRating(), getOwner());
    }
}
