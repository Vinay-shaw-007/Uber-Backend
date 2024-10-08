package com.vinay.project.uber.uberApp.services;

import com.vinay.project.uber.uberApp.entities.Driver;
import com.vinay.project.uber.uberApp.entities.Ride;
import com.vinay.project.uber.uberApp.entities.RideRequest;
import com.vinay.project.uber.uberApp.entities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {

    Ride getRideById(Long rideId);
    Ride createNewRide(RideRequest rideRequest, Driver driver);
    Ride updateRideStatus(Ride ride, RideStatus rideStatus);
    Page<Ride> getAllRidesOfRider(Long riderId, PageRequest pageRequest);
    Page<Ride> getAllRidesOfDriver(Long driverId, PageRequest pageRequest);
}
