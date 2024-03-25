package com.Property.management.Property.Management.Service.Service;

import com.Property.management.Property.Management.Service.Model.Apartment;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
@RequiredArgsConstructor
public class Loader implements ApplicationRunner {
    private  final ApartmentService apartmentService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Apartment> predefinedApartments = Arrays.asList(
                new Apartment(1,"Apartment 1", " Main St", 2),
                new Apartment(2,"Apartment 2", " Elm St", 1),
                new Apartment(3,"Apartment 3", "Oak St", 2)
        );

        // Save the predefined apartments to the database
        for (Apartment apartment : predefinedApartments) {
            apartmentService.registerApartment(apartment);
        }
    }
}
