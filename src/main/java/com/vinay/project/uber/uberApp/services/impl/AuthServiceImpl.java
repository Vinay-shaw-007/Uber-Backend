package com.vinay.project.uber.uberApp.services.impl;

import com.vinay.project.uber.uberApp.dto.DriverDto;
import com.vinay.project.uber.uberApp.dto.SignupDto;
import com.vinay.project.uber.uberApp.dto.UserDto;
import com.vinay.project.uber.uberApp.entities.User;
import com.vinay.project.uber.uberApp.entities.enums.Role;
import com.vinay.project.uber.uberApp.exceptions.RuntimeConflictException;
import com.vinay.project.uber.uberApp.repositories.UserRepository;
import com.vinay.project.uber.uberApp.services.AuthService;
import com.vinay.project.uber.uberApp.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RiderService riderService;

    @Override
    public String login(String email, String password) {
        return null;
    }

    @Override
    @Transactional
    public UserDto signup(SignupDto signupDto) {
        User user = userRepository.findByEmail(signupDto.getEmail()).orElse(null);

        if (user != null) throw new RuntimeConflictException("Cannot Signup, User already exists with email "+signupDto.getEmail());

        User mappedUser = modelMapper.map(signupDto, User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        User savedUser = userRepository.save(mappedUser);

//      create user related entities
        riderService.createNewRider(savedUser);
//      TODO add wallet related service here

        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public DriverDto onboardNewDriver(Long userId) {
        return null;
    }
}
