package com.Property.management.Property.Management.Service.Controller;

import com.Property.management.Property.Management.Service.Model.Apartment;
import com.Property.management.Property.Management.Service.Request.ApartmentRequest;
import com.Property.management.Property.Management.Service.Response.ApartmentResponse;
import com.Property.management.Property.Management.Service.Service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApartmentController {
    public final ApartmentService apartmentService;


    private static final Logger logger = LoggerFactory.getLogger(ApartmentController.class);


    @RequestMapping(method = RequestMethod.POST,value = "/apartments")
    public ApartmentResponse registerApartment(@RequestBody ApartmentRequest request) {
        return apartmentService.registerApartment(request);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/apartments")
    public List<Apartment> getAllApartments() {
        logger.info("Getting apartments................");
        return apartmentService.getAllApartments();
    }


}
