package com.Property.management.Property.Management.Service.Controller;

import com.Property.management.Property.Management.Service.Request.LoginRequest;
import com.Property.management.Property.Management.Service.Request.Request;
import com.Property.management.Property.Management.Service.Response.Loginresponse;
import com.Property.management.Property.Management.Service.Response.RegistrationResponse;
import com.Property.management.Property.Management.Service.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/User")
public class UserController {
    public final UserService service;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(method = RequestMethod.POST, value = "/SignUp")
    public RegistrationResponse registerUser(@RequestBody Request request) {
        logger.info("Lister registration :::::::: " + request);
        return service.registerUser(request);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public Loginresponse UserLogin(@RequestBody LoginRequest loginRequest) {
        System.out.println(loginRequest);
        return service.userLogin(loginRequest);
    }

}
