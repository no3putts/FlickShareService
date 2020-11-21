package com.fickshare.service;

import com.fickshare.domain.Movie;

import java.util.List;

public interface MovieService {
    Movie findOne(String id);
    Movie saveMovie(String imdbid);
    Movie saveMovie(Movie m);
    Movie updateMovie(Movie m);
    List<Movie> findByTitle(String title);
    List<Movie> getImdbMovieByTile(String title);
    Movie getImdbMovie(String imdbId);
    int deleteMovie(String imdbId);
}