package com.Property.management.Property.Management.Service.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BusinessRequest{
        private String businessName;
       private String Address;
       private String registrationNumber;
        private String email;
      private  String phoneNumber;
       private String country;
        private String password;
}
