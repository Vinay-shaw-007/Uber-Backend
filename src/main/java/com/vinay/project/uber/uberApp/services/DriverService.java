package com.vinay.project.uber.uberApp.services;

import com.vinay.project.uber.uberApp.dto.DriverDto;
import com.vinay.project.uber.uberApp.dto.RideDto;
import com.vinay.project.uber.uberApp.dto.RiderDto;

import java.util.List;

public interface DriverService {

    RideDto acceptRide(Long rideId);
    RideDto cancelRide(Long rideId);
    RideDto startRide(Long rideId);
    RideDto endRide(Long Id);
    RiderDto rateRider(Long rideId, Integer rating);
    DriverDto getMyProfile();
    List<RideDto> getAllMyRides();

}
