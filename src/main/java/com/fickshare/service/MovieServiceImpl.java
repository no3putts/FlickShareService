package com.fickshare.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fickshare.domain.Movie;
import com.fickshare.domain.Search;
import com.fickshare.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Value("${omdb.api.key}")
    String apikey;

    private RestTemplate restTemplate;
    private MovieRepo movieRepo;
    private ObjectMapper objectMapper;
    private final String titleUrl = "http://www.omdbapi.com?s=";
    private final String omdbidUrl = "http://www.omdbapi.com?i=";
    private final String apiKeyParam = "&apikey=";

    @Autowired
    public MovieServiceImpl(MovieRepo movieRepo, RestTemplate restTemplate, ObjectMapper objectMapper)
    {
        this.movieRepo = movieRepo;
        this.restTemplate  = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public Movie findOne(String id){
        return movieRepo.findById(id).get();
    }

    @Override
    public Movie saveMovie(String imdbid)
    {
        Movie m = getImdbMovie(imdbid);
       return saveMovie(m);
    }

    @Override
    public Movie saveMovie(Movie m)
    {
        return movieRepo.save(m);
    }

    @Override
    public Movie updateMovie(Movie m)
    {
        return movieRepo.save(m);
    }

    @Override
    public List<Movie> findByTitle(String title){
        return movieRepo.findByTitleIsLike(title);
    }


    @Override
    public List<Movie> getImdbMovieByTile(String title){


        ResponseEntity<String> resp  = restTemplate.getForEntity(titleUrl.concat(title).concat(apiKeyParam), String.class);
        Search movies = null;
        try {
            movies =  objectMapper.readValue(resp.getBody(),Search.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movies.getMovies();
    }

    @Override
    public Movie getImdbMovie(String imdbId)
    {
        ResponseEntity<String> resp = restTemplate.getForEntity(omdbidUrl.concat(imdbId).concat(apiKeyParam).concat(apikey), String.class);
        Movie movies = null;
        try {
            movies =  objectMapper.readValue(resp.getBody(),Movie.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }

    @Override
    public int deleteMovie(String imdbId)
    {
        return movieRepo.deleteByImdbID(imdbId);
    }


}