package com.vinay.project.uber.uberApp.services;

import com.vinay.project.uber.uberApp.dto.DriverDto;
import com.vinay.project.uber.uberApp.dto.RiderDto;
import com.vinay.project.uber.uberApp.entities.Driver;
import com.vinay.project.uber.uberApp.entities.Ride;
import com.vinay.project.uber.uberApp.entities.Rider;

public interface RatingService {

    DriverDto rateDriver(Ride ride, Integer rating);

    RiderDto rateRider(Ride ride, Integer rating);

    void createNewRating(Ride ride);
}
