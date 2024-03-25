package com.Property.management.Property.Management.Service.Request;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
