package com.Property.management.Property.Management.Service.Service;

import com.Property.management.Property.Management.Service.Model.NewUser;
import com.Property.management.Property.Management.Service.Request.LoginRequest;
import com.Property.management.Property.Management.Service.Request.Request;
import com.Property.management.Property.Management.Service.Response.Loginresponse;
import com.Property.management.Property.Management.Service.Response.RegistrationResponse;
import com.Property.management.Property.Management.Service.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final password password;

    public RegistrationResponse registerUser(Request request) {
        NewUser user = new NewUser();
        RegistrationResponse response = new RegistrationResponse();
        try {
            // this method to to check if any of the entity is absent or empty
            if (request.firstName().isEmpty() || request.lastName().isEmpty() || request.email().isEmpty() || request.mobileNumber().isEmpty() || request.password().isEmpty() || request.address().isEmpty() || request.city().isEmpty()) {
                response.setDescription("All fields are compulsory. Please fill in all required information.");
                return response;
            }
            Optional<NewUser> User = this.findByEmail(request.email());
            if (User.isPresent()) {
                response.setDescription(User + "Already Exist");
                return response;
            }
            user.setFirstName(request.firstName());
            user.setLastName(request.lastName());
            user.setEmail(request.email());
            user.setMobileNumber(request.mobileNumber());
            user.setPassword(password.bCryptPasswordEncoder().encode(request.password()));
            user.setAddress(request.address());
            user.setCity(request.city());
            repository.save(user);

            response.setDescription("Registration Successful");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    public Loginresponse userLogin(LoginRequest loginRequest) {
        Loginresponse loginResponse = new Loginresponse();
        try {
            Optional<NewUser> userOptional = repository.findByEmail(loginRequest.getEmail());
            if (userOptional.isPresent()) {
                NewUser user = userOptional.get();
                // this is to check if the password matches or not
                if (password.bCryptPasswordEncoder().matches(loginRequest.getPassword(), user.getPassword())) {
                    user.setLastLogin(LocalDateTime.now());
                    repository.save(user);
                    loginResponse.setEmail(user.getEmail());
                    loginResponse.setStatus("00");
                    loginResponse.setStatusDescription("Login Successful");
                } else {
                    loginResponse.setStatus("01");
                    loginResponse.setStatusDescription("Invalid email or password");
                }
            } else {
                loginResponse.setStatus("02");
                loginResponse.setStatusDescription("User not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            loginResponse.setStatus("99");
            loginResponse.setStatusDescription("An error occurred while processing your request");
        }
        return loginResponse;
    }

    // this is to find by email
    public Optional<NewUser> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
