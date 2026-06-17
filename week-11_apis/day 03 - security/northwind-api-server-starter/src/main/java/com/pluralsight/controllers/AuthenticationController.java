package com.pluralsight.controllers;

import com.pluralsight.repositories.ProfilesRepository;
import com.pluralsight.repositories.UsersRepository;
import jakarta.annotation.security.PermitAll;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.pluralsight.models.Profile;
import com.pluralsight.models.User;
import com.pluralsight.models.authentication.LoginDto;
import com.pluralsight.models.authentication.LoginResponseDto;
import com.pluralsight.models.authentication.RegisterUserDto;
import com.pluralsight.security.jwt.JWTFilter;
import com.pluralsight.security.jwt.TokenProvider;

import jakarta.validation.Valid;

import java.net.URI;

@RestController
@CrossOrigin

public class AuthenticationController
{

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private UsersRepository usersRepository;
    private ProfilesRepository profilesRepository;

    public AuthenticationController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, UsersRepository usersRepository, ProfilesRepository profilesRepository) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.usersRepository = usersRepository;
        this.profilesRepository = profilesRepository;
    }

    @PostMapping("/login")
    @PermitAll
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginDto loginDto) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication, false);

        try
        {
            User user = usersRepository.getByUserName(loginDto.getUsername());

            if (user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

            return ResponseEntity
                    .ok()
                    .header(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt)
                    .body(new LoginResponseDto(jwt, user));
        }
        catch(Exception ex)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/register")
    @PermitAll
    public ResponseEntity<?> register(@Valid @RequestBody RegisterUserDto newUser) {

        try
        {
            boolean exists = usersRepository.exists(newUser.getUsername());
            if (exists)
            {
                return ResponseEntity.badRequest().body("User Already Exists");
            }

            // create user
            User user = usersRepository.create(new User(0, newUser.getUsername(), newUser.getPassword(), newUser.getRole()));

            // create profile
            Profile profile = new Profile();
            profile.setUserId(user.getId());
            profilesRepository.save(profile);

            URI location = URI.create("/users/" + user.getUsername());
            return ResponseEntity.created(location).body(user);
        }
        catch (Exception e)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }
    }

}

