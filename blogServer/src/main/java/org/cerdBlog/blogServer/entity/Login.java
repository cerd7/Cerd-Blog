package org.cerdBlog.blogServer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Login {

    @Id
    private String userEmail;
    private String userPassword;

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
