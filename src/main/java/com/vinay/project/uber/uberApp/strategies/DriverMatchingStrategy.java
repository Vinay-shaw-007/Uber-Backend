package com.vinay.project.uber.uberApp.strategies;

import com.vinay.project.uber.uberApp.dto.RideRequestDto;
import com.vinay.project.uber.uberApp.entities.Driver;

import java.util.List;

public interface DriverMatchingStrategy {

    List<Driver> findMatchingDriver(RideRequestDto rideRequestDto);
}
