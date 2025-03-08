package org.cerdBlog.blogServer.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private String userEmail;
    private String userPassword;
}
