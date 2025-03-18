package com.cerdblog.springserver.dto;

import com.cerdblog.springserver.entity.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class UserDTO {

    private long id;
    private String username;
    private String userEmail;
    private String userPassword;

    public UserDTO()
    {
    }

    public UserDTO(User user)
    {
        BeanUtils.copyProperties(user, this);
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
