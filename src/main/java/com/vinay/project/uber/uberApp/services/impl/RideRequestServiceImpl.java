package com.vinay.project.uber.uberApp.services.impl;

import com.vinay.project.uber.uberApp.entities.RideRequest;
import com.vinay.project.uber.uberApp.exceptions.ResourceNotFoundException;
import com.vinay.project.uber.uberApp.repositories.RideRequestRepository;
import com.vinay.project.uber.uberApp.services.RideRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideRequestServiceImpl implements RideRequestService {

    private final RideRequestRepository rideRequestRepository;

    @Override
    public RideRequest findRideRequestById(Long rideRequestId) {
        return rideRequestRepository.findById(rideRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("RideRequest not found with id: "+rideRequestId));
    }

    @Override
    public void update(RideRequest rideRequest) {
        rideRequestRepository.findById(rideRequest.getId())
                .orElseThrow(() -> new ResourceNotFoundException("RideRequest not found with id: "+rideRequest.getId()));

        rideRequestRepository.save(rideRequest);
    }
}
