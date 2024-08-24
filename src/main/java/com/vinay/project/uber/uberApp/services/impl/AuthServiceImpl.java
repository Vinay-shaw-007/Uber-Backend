package com.vinay.project.uber.uberApp.services.impl;

import com.vinay.project.uber.uberApp.dto.DriverDto;
import com.vinay.project.uber.uberApp.dto.SignupDto;
import com.vinay.project.uber.uberApp.dto.UserDto;
import com.vinay.project.uber.uberApp.services.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public String login(String email, String password) {
        return null;
    }

    @Override
    public UserDto signup(SignupDto signupDto) {
        return null;
    }

    @Override
    public DriverDto onboardNewDriver(Long userId) {
        return null;
    }
}
