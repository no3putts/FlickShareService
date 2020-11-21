package com.fickshare.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;


/**
 * Wrapper for Result Set.
 * Used when Returning a list of Movies
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Search
{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Search search = (Search) o;
        return Objects.equals(getMovies(), search.getMovies());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMovies());
    }

    @JsonProperty("Search")
    List<Movie> movies;

    public List<Movie> getMovies ()
    {
        return movies;
    }

    public void setMovies (final List<Movie> movies)
    {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Search{" +
                "movies=" + movies +
                '}';
    }
}
