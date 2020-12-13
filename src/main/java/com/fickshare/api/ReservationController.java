package com.fickshare.api;


import com.fickshare.domain.Reservation;
import com.fickshare.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/api/reservation")
public class ReservationController
{
    final ReservationService service;

    @Autowired
    public ReservationController(ReservationService reservationService){
        this.service = reservationService;
    }

    @GetMapping(value="/{userid}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Returns a list of reservations made by a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the reservations",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Reservation.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid username supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Reservations not found", content = @Content) })
    public List<Reservation> findUserReservation(@PathVariable String userid)
    {
        long userId = 1;  // Everything is assigned to the test user for now
        return service.findReservationByUser(userId);
    }

    @PostMapping(value = "/{imdbId}/{userid}")
    @Operation(summary = "Reserves a Movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie successfully reserved",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Reservation.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid imdbid supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content) })
    public Reservation reserveMovie(@PathVariable String imdbId, @PathVariable String userid)
    {
        return service.reserveMovie(imdbId, userid);
    }

    @DeleteMapping(value = "/{resid}")
    @Operation(summary = "Return a Reservation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reservation successfully removed",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Reservation.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid reservation ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Reservation not found", content = @Content) })
    public String returnReservation(@PathVariable String resid)
    {
        return "Success";
    }

    @PutMapping(value = "/{resid}")
    @Operation(summary = "Cancels a Reservation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reservation successfully cancelled",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Reservation.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid reservation ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Reservation not found", content = @Content) })
    public String cancelReservation(@PathVariable String resid)
    {
        return "Success";
    }

}
