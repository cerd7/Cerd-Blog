package org.cerdBlog.blogServer.service;

import jakarta.persistence.EntityNotFoundException;
import org.cerdBlog.blogServer.entity.Login;
import org.cerdBlog.blogServer.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Login authLogin(String userEmail, String userPassword) {
        Login login = loginRepository.findByUserEmailAndUserPassword(userEmail, userPassword)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        if (!login.getUserEmail().equals(userEmail) || !login.getUserPassword().equals(userPassword)) {
            throw new EntityNotFoundException("Email ou senha invalidos");
        }
        return login;
    }

    @Override
    public void saveUser(Login login) {
        loginRepository.save(login);
    }
}
