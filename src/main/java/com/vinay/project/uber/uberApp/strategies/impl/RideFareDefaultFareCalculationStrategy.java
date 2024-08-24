package com.vinay.project.uber.uberApp.strategies.impl;

import com.vinay.project.uber.uberApp.dto.RideRequestDto;
import com.vinay.project.uber.uberApp.strategies.RideFareCalculationStrategy;
import org.springframework.stereotype.Service;

@Service
public class RideFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {
    @Override
    public double calculateFare(RideRequestDto rideRequestDto) {
        return 0;
    }
}
