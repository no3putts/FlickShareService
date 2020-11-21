package com.fickshare.api;


import com.fickshare.domain.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController
{

    @GetMapping(value="/{userid}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Returns User Information for a given userid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the User",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid userId supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content) })
    public User findUserByUserId(@PathVariable String userId)
    {
        return new User();
    }

    @PutMapping
    @Operation(summary = "Updates a User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie successfully updated",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid User Data supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content) })
    public User update(@RequestBody User user)
    {
        return new User();
    }

    @PostMapping
    @Operation(summary = "Create a User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully created",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid user data", content = @Content)})
    public User createUser(@RequestBody User user)
    {
        return new User();
    }


    @DeleteMapping(value = "/{userid}")
    @Operation(summary = "Removes User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully removed",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid User ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content) })
    public String deleteMovieById(@PathVariable String userid)
    {
        return "Success";
    }

}
