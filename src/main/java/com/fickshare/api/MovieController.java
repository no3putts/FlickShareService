package com.fickshare.api;


import com.fasterxml.jackson.databind.node.TextNode;
import com.fickshare.domain.Movie;
import com.fickshare.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/movie")
public class MovieController
{

    private final String LOCAL = "local";

    final MovieService service;


    @Autowired
    public MovieController(MovieService movieService){
        this.service = movieService;
    }

    @GetMapping(value="/{imdbid}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Returns a single Movie based on imdbid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Movie",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Movie.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid imdbid supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content) })
    public Movie findMovieById(@PathVariable String imdbid,
                               @Parameter(description="Specifies which source to query.  Possible (local | omdb)") @RequestParam(required = false,name = "source",defaultValue = "local") String source)
    {
        if (source.equalsIgnoreCase(LOCAL))
            return service.findOne(imdbid);
        else
            return service.getImdbMovie(imdbid);
    }

    @GetMapping(value ="/title/{title}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Returns a list of Movies based on title")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Movie",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Movie.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Title supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content) })
    public List<Movie> findMovieByTitle(@PathVariable String title,
                                        @Parameter(description="Specifies which source to query.  Possible (local | omdb") @RequestParam(required = false,name = "source",defaultValue = "omdb") String source)
    {
        if (source.equalsIgnoreCase(LOCAL))
            return service.findByTitle(title);
        else
            return service.getImdbMovieByTile(title);
    }

    @PutMapping(value="/{imdbid}")
    @Operation(summary = "Update Movie Information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie information successfully updated",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Movie.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid imdbid supplied or invalid data provided", content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content) })
    public Movie updateMovieInfo(@PathVariable String imdbid, @RequestBody String comment)
    {
        return service.updateMovie(imdbid, comment);
    }

    @PostMapping(value = "/{imdbid}/{owner}")
    @Operation(summary = "Add Movie to the local database by fetching Movie info from the Web")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie successfully added",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Movie.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid imdbid supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content) })
    public Movie createMovie(@PathVariable String imdbid, @PathVariable String owner)
    {
        return service.saveMovie(imdbid,owner);

    }

    @PostMapping
    @Operation(summary = "Add Movie to the local database with manually entered information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie successfully added",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Movie.class)) }),
            @ApiResponse(responseCode = "400", description = "Unexpeted error.  Please try again later", content = @Content)})
    public Movie createNewMovie(@RequestBody Movie movie)
    {
        return service.saveMovie(movie);

    }

    @DeleteMapping(value = "/{imdbid}")
    @Operation(summary = "Removes Movie from local database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie successfully removed",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Movie.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid imdbid supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content) })
    public void deleteMovieById(@PathVariable String imdbid)
    {
        service.deleteMovie(imdbid);
    }

}
