package com.fickshare.repo;

import com.fickshare.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepo extends JpaRepository<Movie,String>
{
    List<Movie> findByTitleLike(@Param(value = "title") String title);
    Movie findByImdbID(@Param(value = "imdbId") String imdbId);
    int deleteByImdbID(@Param(value="imdbId") String imdbId);
}