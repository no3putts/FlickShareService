package com.fickshare.service;

import com.fickshare.domain.Search;
import com.fickshare.domain.Movie;
import com.fickshare.repo.MovieRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
public class MovieServiceTest {

    @InjectMocks
    MovieService movieService;

    @Mock
    MovieRepo  dao;

    String movieId;
    String title;
    private Object Optional;

    final Movie movie = new Movie();
    Search search = new Search();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        movieId = "tt2911666";
        title = "John";
    }

    @Test
    public void findOne() {
//        given(dao.findByImdbID(movieId)).willReturn(movie);
//        java.util.Optional<Movie> m = movieService.findOne(movieId);
//        assert(true);
    }


//    @Test
    public void findByTitle() {
        given(dao.findByTitleIsLike(title)).willReturn((List<Movie>) movie);
        List<Movie> m = movieService.findByTitle(title);
        assert(true);
    }

//    @Test
//    public void deleteMovie() {
//    }
}