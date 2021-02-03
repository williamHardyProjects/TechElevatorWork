package com.techelevator.vendingmachine.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.vendingmachine.dao.UserDAO;
import com.techelevator.vendingmachine.exceptions.UserAlreadyExistsException;
import com.techelevator.vendingmachine.models.security.LoginDTO;
import com.techelevator.vendingmachine.models.security.RegisterUserDTO;
import com.techelevator.vendingmachine.models.security.User;
import com.techelevator.vendingmachine.security.jwt.JWTFilter;
import com.techelevator.vendingmachine.security.jwt.TokenProvider;

/**
 * Controller to authenticate users.
 */
@RestController
public class AuthenticationController
{
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private UserDAO userDAO;

    public AuthenticationController(TokenProvider tokenProvider,
            AuthenticationManagerBuilder authenticationManagerBuilder, UserDAO userDAO)
    {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userDAO = userDAO;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginDTO loginDto)
    {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication, false);

        User user = userDAO.findByUsername(loginDto.getUsername());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
        return new ResponseEntity<>(new LoginResponse(jwt, user), httpHeaders, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public void register(@Valid @RequestBody RegisterUserDTO newUser)
    {
            User user = userDAO.findByUsername(newUser.getUsername());
            if (user != null)
            {
                throw new UserAlreadyExistsException();
            }

            userDAO.create(newUser.getUsername(), newUser.getPassword());
    }

    /**
     * Object to return as body in JWT Authentication.
     */
    static class LoginResponse
    {

        private String token;
        private User user;

        LoginResponse(String token, User user)
        {
            this.token = token;
            this.user = user;
        }

        @JsonProperty("token")
        String getToken()
        {
            return token;
        }

        void setToken(String token)
        {
            this.token = token;
        }

        @JsonProperty("user")
        public User getUser()
        {
            return user;
        }

        public void setUser(User user)
        {
            this.user = user;
        }
    }
}
