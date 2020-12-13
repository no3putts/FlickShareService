package com.fickshare.service;

import com.fickshare.domain.Movie;

import java.util.List;

public interface MovieService {
    Movie findOne(String id);
    Movie saveMovie(String imdbid, String owner);
    Movie saveMovie(Movie m);
    Movie updateMovie(String imdbid, String comment);
    List<Movie> findByTitle(String title);
    List<Movie> getImdbMovieByTile(String title);
    Movie getImdbMovie(String imdbId);
    int deleteMovie(String imdbId);
}
