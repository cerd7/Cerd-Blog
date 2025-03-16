package com.cerdblog.springserver.service;

import com.cerdblog.springserver.entity.User;

public interface UserService {
    User loadUserByUsername(String userName);

    User saveUser(User user);
}