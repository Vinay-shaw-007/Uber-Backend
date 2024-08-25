package com.vinay.project.uber.uberApp.controllers;

import com.vinay.project.uber.uberApp.dto.SignupDto;
import com.vinay.project.uber.uberApp.dto.UserDto;
import com.vinay.project.uber.uberApp.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping(path = "/signup")
    UserDto signUp(@RequestBody SignupDto signupDto) {
        return authService.signup(signupDto);
    }
}
