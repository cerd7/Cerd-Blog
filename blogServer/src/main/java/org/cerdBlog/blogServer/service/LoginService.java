package org.cerdBlog.blogServer.service;

import org.cerdBlog.blogServer.entity.Login;

public interface LoginService {
    Login authLogin(String userEmail, String userPassword);

    void saveUser(Login login);
}