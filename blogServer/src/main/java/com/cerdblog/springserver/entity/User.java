package com.cerdblog.springserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import com.cerdblog.springserver.dto.UserDTO;
import org.springframework.beans.BeanUtils;

@Entity
public class User {

    @Id
    @Column
    private long id;
    @Column
    private String username;
    @Column
    private String userEmail;
    @Column
    private String userPassword;

    public User()
    {}

    public User(UserDTO userDTO)
    {
        BeanUtils.copyProperties(userDTO, this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
