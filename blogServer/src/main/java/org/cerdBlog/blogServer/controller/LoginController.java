package org.cerdBlog.blogServer.controller;

import jakarta.persistence.EntityNotFoundException;
import org.cerdBlog.blogServer.dto.LoginDTO;
import org.cerdBlog.blogServer.entity.Login;
import org.cerdBlog.blogServer.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> authLogin(@RequestBody LoginDTO loginDTO) {
        try {
            Login login = loginService.authLogin(loginDTO.getUserEmail(), loginDTO.getUserPassword());
            return ResponseEntity.ok("Login realizado com sucesso!");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PutMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Login newUser) {
        loginService.saveUser(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado com sucesso!");
    }
}
