package com.Property.management.Property.Management.Service.Controller;

import com.Property.management.Property.Management.Service.Request.BusinessRequest;
import com.Property.management.Property.Management.Service.Response.BusinessResponse;
import com.Property.management.Property.Management.Service.Service.BusinessService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class BusinessController {
    private final BusinessService businessService;


    private static final Logger logger = LoggerFactory.getLogger(BusinessController.class);

    @RequestMapping(method = RequestMethod.POST, value = "/addBusiness")
    public BusinessResponse createBusiness(@RequestBody BusinessRequest Request) {
        logger.info("Creating business ::::::::::::::::::::::::::: " + Request);
        return businessService.createBusiness(Request);
    }
}
