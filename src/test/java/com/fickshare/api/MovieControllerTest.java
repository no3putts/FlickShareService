package com.fickshare.api;

import com.fickshare.service.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)
//@SpringBootTest(
//        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
//        classes = MovieServiceApplication.class)
//@AutoConfigureMockMvc
public class MovieControllerTest {

    private String movieId;
    private String title;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @Before
    public void setUp() {
        this.mockMvc = standaloneSetup(new MovieController(movieService)).build();
        movieId = "tt2911666";
        title = "John";
    }

    @Test
    public void findMovieById() throws Exception {
//        mockMvc.perform(get("/local/{imdbId}",
//                movieId)
//                .accept(MediaType.APPLICATION_JSON))
////                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findMovie() throws Exception {
        mockMvc.perform(get("/local/title/{title}",
                title)
                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @Test
    public void findMovieService() throws Exception {
        Object o = movieService.findByTitle("Some Movie");
        assert(o == null);
    }

    @Test
    public void findOmdbMovie() throws Exception {
        mockMvc.perform(get("/omdb/title{title}",
                title)
                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

//    @Test
    public void findOmdbMovieDetail() throws Exception {
        mockMvc.perform(get("/omdb/{imdbId}",
                movieId)
                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

//    @Test
//    public void createMovie() {
//    }
//
//    @Test
//    public void testDataSizeLimit() {
//    }
//
//    @Test
//    public void deleteMovie() {
//
//    }
}