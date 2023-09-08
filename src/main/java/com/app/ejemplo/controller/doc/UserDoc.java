package com.app.ejemplo.controller.doc;

import com.app.ejemplo.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "User", description = "User Service")
public interface UserDoc {
    @Operation(summary = "Create User")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "User Created",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(
                            responseCode = "400",
                            description = "bad request",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            }
    )
    ResponseEntity create(
            @RequestBody UserDTO userDTO
            );

    @Operation(summary = "get All User",
               description = "This operation list all user")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "get list of users",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(
                            responseCode = "400",
                            description = "bad request",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            }
    )
    ResponseEntity getAllUser();

    @Operation(summary = "get User by id")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "get user by Id",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(
                            responseCode = "400",
                            description = "bad request",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            }
    )
    ResponseEntity getUserById(@PathVariable long id);

    @Operation(summary = "get User by email")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "get user by email",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(
                            responseCode = "400",
                            description = "bad request",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            }
    )
    ResponseEntity getUserByEmail(@PathVariable String email);


    @Operation(summary = "Delete User by id")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "user was deleted",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(
                            responseCode = "400",
                            description = "bad request",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            }
    )
    ResponseEntity deleteUserById(@PathVariable long id);
}
