package com.vinay.project.uber.uberApp.strategies;

import com.vinay.project.uber.uberApp.dto.RideRequestDto;

public interface RideFareCalculationStrategy {

    double calculateFare(RideRequestDto rideRequestDto);
}
