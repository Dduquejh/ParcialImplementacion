package com.parcial.parcialimplementacion.User;

import com.parcial.parcialimplementacion.config.JwtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the application, this endpoint is not secure";
    }

    @PostMapping("/addNewUser")
    public String addNewUser(UserInfo userInfo) {
        return userInfoService.addUser(userInfo);
    }

    // This endpoint is secured and only accessible by users with the role of ADMIN
    @PreAuthorize("hasAuthority('ADMIN_ROLE')")
    @GetMapping("/admin/adminProfiler")
    public String adminProfiler(@RequestHeader("Authorization") String token) {
        System.out.println("Admin profiler accessed");
        return "Welcome to the admin profiler, this endpoint is secure";
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
        );
        if (authentication.isAuthenticated()) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            System.out.println("User authenticated");
            return jwtService.generateToken(userDetails);
        } else {
            System.out.println("User not authenticated");
            throw new UsernameNotFoundException("Invalid credentials");
        }
    }

    @GetMapping("/getUserData")
    public String getUserData(@RequestHeader("Authorization") String token) {
        if (token.startsWith("Bearer "))
            token = token.substring(7);
        return jwtService.extractUsername(token);
    }
}
