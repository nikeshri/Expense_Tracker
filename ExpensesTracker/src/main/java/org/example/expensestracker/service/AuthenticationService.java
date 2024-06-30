package org.example.expensestracker.service;

import lombok.RequiredArgsConstructor;
import org.example.expensestracker.dto.LoginDto;
import org.example.expensestracker.dto.RegisterDto;
import org.example.expensestracker.model.User;
import org.example.expensestracker.repo.UserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;



    public User signUp(RegisterDto registerDto)
    {

        if(userRepo.findUserByEmail(registerDto.getEmail()).isPresent())
        {
            throw  new IllegalArgumentException("User is already exist");
        }

        User user = new User();
        user.setEmail(registerDto.getEmail());
        user.setFName(registerDto.getFName());
        user.setLName(registerDto.getLName());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        return userRepo.save(user);

    }

    public User signIn(LoginDto loginDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        User user = userRepo.findUserByEmail(loginDto.getEmail()).orElseThrow();
        return user;
    }
}
