package com.vinay.project.uber.uberApp.controllers;

import com.vinay.project.uber.uberApp.dto.*;
import com.vinay.project.uber.uberApp.services.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import java.lang.reflect.Array;
import java.util.Arrays;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping(path = "/signup")
    ResponseEntity<UserDto> signUp(@RequestBody SignupDto signupDto) {
        return new ResponseEntity<>(authService.signup(signupDto), HttpStatus.CREATED);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping(path = "/onBoardNewDriver/{userId}")
    ResponseEntity<DriverDto> signUp(@PathVariable Long userId, @RequestBody OnBoardDriverDto onBoardDriverDto) {
        return new ResponseEntity<>(authService.onboardNewDriver(userId, onBoardDriverDto.getVehicleId()), HttpStatus.CREATED);
    }

    @PostMapping(path = "/login")
    ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto,
                                           HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String[] tokens = authService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());

        Cookie cookie = new Cookie("token", tokens[1]);
        cookie.setSecure(false); //for dev set to false, for prod it should be true;
        cookie.setHttpOnly(true);

        httpServletResponse.addCookie(cookie);

        return ResponseEntity.ok(new LoginResponseDto(tokens[0]));
    }

    @PostMapping(path = "/refresh")
    public ResponseEntity<LoginResponseDto> refresh(HttpServletRequest httpServletRequest) {
        String refreshToken = Arrays.stream(httpServletRequest.getCookies())
                .filter(cookie -> "token".equals(cookie.getName()))
                .findFirst()
                .map(Cookie::getValue)
                .orElseThrow(() -> new AuthenticationServiceException("Refresh token not found inside the cookies"));

        String accessToken = authService.refreshToken(refreshToken);

        return ResponseEntity.ok(new LoginResponseDto(accessToken));
    }
}
