package com.vinay.project.uber.uberApp.controllers;

import com.vinay.project.uber.uberApp.dto.RideRequestDto;
import com.vinay.project.uber.uberApp.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/riders")
@RequiredArgsConstructor
public class RiderController {

    private final RiderService riderService;

    @PostMapping(path = "/requestRide")
    public ResponseEntity<RideRequestDto> requestRide(@RequestBody RideRequestDto rideRequestDto) {
        return ResponseEntity.ok(riderService.requestRide(rideRequestDto));
    }
}
