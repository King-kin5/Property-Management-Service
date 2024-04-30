package com.Property.management.Property.Management.Service.Service;

import com.Property.management.Property.Management.Service.Model.Business;
import com.Property.management.Property.Management.Service.Repository.BusinessRepository;
import com.Property.management.Property.Management.Service.Request.BusinessRequest;
import com.Property.management.Property.Management.Service.Response.BusinessResponse;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BusinessService {
    private final BusinessRepository businessRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(BusinessService.class);


    public synchronized BusinessResponse createBusiness(BusinessRequest  Request) {

        try {
            Business newBusiness = new Business();
            BusinessResponse businessResponse = new BusinessResponse();
            businessResponse.setBusinessName(Request.getBusinessName());

            if (!businessRepository.findByEmail(Request.getEmail()).isPresent()) {
                newBusiness.setBusinessName(Request.getBusinessName());
                newBusiness.setAddress(Request.getAddress());
                newBusiness.setRegistrationNumber(Request.getRegistrationNumber());
                newBusiness.setEmail(Request.getEmail().toLowerCase());
                newBusiness.setPhoneNumber(Request.getPhoneNumber());
                newBusiness.setCountry(Request.getCountry());
                newBusiness.setPassword(bCryptPasswordEncoder.encode(Request.getPassword()));

                businessRepository.save(newBusiness);


            } else {
                businessResponse.setMessage("Business already exists");
            }

            return businessResponse;
        } catch (Exception e) {
            logger.error("Error creating business: ", e);
            e.printStackTrace();
            return null;
        }
    }

}
