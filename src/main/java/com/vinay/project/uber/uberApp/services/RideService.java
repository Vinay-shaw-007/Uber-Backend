package com.vinay.project.uber.uberApp.services;

import com.vinay.project.uber.uberApp.dto.DriverDto;
import com.vinay.project.uber.uberApp.dto.RideDto;
import com.vinay.project.uber.uberApp.dto.RideRequestDto;
import com.vinay.project.uber.uberApp.dto.RiderDto;
import com.vinay.project.uber.uberApp.entities.Driver;
import com.vinay.project.uber.uberApp.entities.Ride;
import com.vinay.project.uber.uberApp.entities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface RideService {

    Ride getRideById(Long rideId);
    void matchWithDrivers(RideRequestDto rideRequestDto);
    Ride createNewRide(RideRequestDto rideRequestDto, Driver driver);
    Ride updateRideStatus(Long rideId, RideStatus rideStatus);
    Page<Ride> getAllRidesOrRider(Long riderId, PageRequest pageRequest);
    Page<Ride> getAllRidesOfDriver(Long driverId, PageRequest pageRequest);
}
