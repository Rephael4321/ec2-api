package com.codingbc.runmydocker.controllers;

import com.codingbc.runmydocker.dto.ApiResponse;
import com.codingbc.runmydocker.dto.Ec2Server.*;
import com.codingbc.runmydocker.services.Ec2ServerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.codingbc.runmydocker.dto.ApiResponse.success;

@RestController
@RequestMapping("/api/ec2Servers")
public class Ec2ServerController {

    private final Ec2ServerService ec2ServerService;

    public Ec2ServerController(Ec2ServerService ec2ServerService) {
        this.ec2ServerService = ec2ServerService;
    }

    @PostMapping("/create")
    @ApiOperation(value = "Create a new EC2 server")
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 201, message = "Server created successfully"),
            @io.swagger.annotations.ApiResponse(code = 400, message = "Port out of range or malformed request", response = ApiResponse.class),
            @io.swagger.annotations.ApiResponse(code = 409, message = "App name already exists or EC2 type unsupported", response = ApiResponse.class)
    })
    public ResponseEntity<ApiResponse<Ec2ServerCreateResponse>> create(
            @RequestBody @Valid Ec2ServerCreateRequest request) {
        Ec2ServerCreateResponse serverOut = ec2ServerService.create(request);
        var apiResponse = success(serverOut, "Server created successfully", HttpStatus.CREATED, null);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PostMapping("/start")
    @ApiOperation(value = "Start EC2 server")
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Server started successfully"),
            @io.swagger.annotations.ApiResponse(code = 404, message = "No server found with this address", response = ApiResponse.class),
            @io.swagger.annotations.ApiResponse(code = 409, message = "Server already up", response = ApiResponse.class)
    })
    public ResponseEntity<ApiResponse<Ec2ServerActionResponse>> start(
            @RequestBody @Valid Ec2ServerActionRequest request) {
        Ec2ServerActionResponse serverOut = ec2ServerService.start(request);
        ApiResponse<Ec2ServerActionResponse> apiResponse = ApiResponse.success(serverOut,
                "Server started successfully",
                HttpStatus.OK, null);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/stop")
    @ApiOperation(value = "Stop EC2 server")
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Server stopped successfully"),
            @io.swagger.annotations.ApiResponse(code = 404, message = "No server found with this address", response = ApiResponse.class),
            @io.swagger.annotations.ApiResponse(code = 409, message = "Server already down", response = ApiResponse.class)
    })
    public ResponseEntity<ApiResponse<Ec2ServerActionResponse>> stop(
            @RequestBody @Valid Ec2ServerActionRequest request) {
        Ec2ServerActionResponse serverOut = ec2ServerService.stop(request);
        var apiResponse = success(serverOut, "Server stopped successfully", HttpStatus.OK, null);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/restart")
    @ApiOperation(value = "Restart EC2 server")
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Server restarted successfully"),
            @io.swagger.annotations.ApiResponse(code = 404, message = "No server found with this address", response = ApiResponse.class)
    })
    public ResponseEntity<ApiResponse<Ec2ServerActionResponse>> restart(
            @RequestBody @Valid Ec2ServerActionRequest request) {
        Ec2ServerActionResponse serverOut = ec2ServerService.restart(request);
        var apiResponse = success(serverOut, "Server restarted successfully", HttpStatus.OK, null);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/terminate")
    @ApiOperation(value = "Terminate EC2 server")
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Server terminated successfully"),
            @io.swagger.annotations.ApiResponse(code = 404, message = "No server found with this address", response = ApiResponse.class)
    })
    public ResponseEntity<ApiResponse<Ec2ServerActionResponse>> terminate(
            @RequestBody @Valid Ec2ServerActionRequest request) {
        Ec2ServerActionResponse serverOut = ec2ServerService.terminate(request);
        var apiResponse = success(serverOut, "Server terminated successfully", HttpStatus.OK, null);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/details")
    @ApiOperation(value = "Get EC2 server details")
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Server details fetched successfully"),
            @io.swagger.annotations.ApiResponse(code = 404, message = "No server found with this address", response = ApiResponse.class)
    })
    public ResponseEntity<ApiResponse<Ec2ServerGetDetailsResponse>> getDetails(
            @RequestBody @Valid Ec2ServerGetDetailsRequest request) {
        Ec2ServerGetDetailsResponse serverOut = ec2ServerService.getDetails(request);
        var apiResponse = success(serverOut, "Server details fetched successfully", HttpStatus.OK, null);
        return ResponseEntity.ok(apiResponse);
    }
}
