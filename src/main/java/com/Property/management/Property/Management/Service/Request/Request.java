package com.Property.management.Property.Management.Service.Request;

public record Request(
        String firstName,
        String lastName,
        String email,
        String mobileNumber,
        String address,
        String city,
        String password
) {
}
