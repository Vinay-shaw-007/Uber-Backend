package com.vinay.project.uber.uberApp.controllers;

import com.vinay.project.uber.uberApp.dto.DriverDto;
import com.vinay.project.uber.uberApp.dto.OnBoardDriverDto;
import com.vinay.project.uber.uberApp.dto.SignupDto;
import com.vinay.project.uber.uberApp.dto.UserDto;
import com.vinay.project.uber.uberApp.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping(path = "/signup")
    ResponseEntity<UserDto> signUp(@RequestBody SignupDto signupDto) {
        return new ResponseEntity<>(authService.signup(signupDto), HttpStatus.CREATED);
    }

    @PostMapping(path = "/onBoardNewDriver/{userId}")
    ResponseEntity<DriverDto> signUp(@PathVariable Long userId, @RequestBody OnBoardDriverDto onBoardDriverDto) {
        return new ResponseEntity<>(authService.onboardNewDriver(userId, onBoardDriverDto.getVehicleId()), HttpStatus.CREATED);
    }
}
