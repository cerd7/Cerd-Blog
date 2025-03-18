package com.cerdblog.springserver.controller;

import com.cerdblog.springserver.authentication.util.JwtUtils;
import com.cerdblog.springserver.service.serviceImp.UserServiceImp;
import com.cerdblog.springserver.dto.UserDTO;
import com.cerdblog.springserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class UserController{

    private final AuthenticationManager authenticationManager;
    private final UserServiceImp userServiceImp;
    private final JwtUtils jwtUtils;

    @Autowired
    public UserController(AuthenticationManager authenticationManager, UserServiceImp userServiceImp, JwtUtils jwtUtils)
    {
        this.authenticationManager = authenticationManager;
        this.userServiceImp = userServiceImp;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/register") // De PutMapping para PostMapping
    public ResponseEntity<?> registerUser(@RequestBody UserDTO newUser) {
        User userRegisterEntity = new User(newUser);

        if (userServiceImp.findByUsername(userRegisterEntity.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username is already taken");
        }

        userServiceImp.saveUser(userRegisterEntity);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping
    public ResponseEntity<?> authLogin(@RequestBody UserDTO usernameLogin) {
        try {
            User userEntityLogin = new User(usernameLogin);
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userEntityLogin.getUsername(), userEntityLogin.getUserPassword()));
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            String jwt = jwtUtils.generateToken(userDetails);
            Map<String, String> response = new HashMap<>();
            response.put("TOKEN", jwt);
            return ResponseEntity.ok(response);
        }catch (AuthenticationException e)
        {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}
