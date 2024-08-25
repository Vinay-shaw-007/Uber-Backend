package com.vinay.project.uber.uberApp.strategies.impl;

import com.vinay.project.uber.uberApp.entities.RideRequest;
import com.vinay.project.uber.uberApp.services.DistanceService;
import com.vinay.project.uber.uberApp.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RideFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(), rideRequest.getDropOffLocation());
        return distance * RIDE_FARE_MULTIPLIER;
    }
}
