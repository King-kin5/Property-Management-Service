package com.Property.management.Property.Management.Service.Service;

import com.Property.management.Property.Management.Service.Repository.ApartmentRepository;
import com.Property.management.Property.Management.Service.Model.Apartment;
import com.Property.management.Property.Management.Service.Request.ApartmentRequest;
import com.Property.management.Property.Management.Service.Response.ApartmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;

    public ApartmentResponse registerApartment(ApartmentRequest request) {
        Apartment apartment=new Apartment();
        ApartmentResponse response=new ApartmentResponse();
        try {
            if (request.address().isEmpty()||request.name().isEmpty()){
                response.setDescription("MAKE SURE ALL ENTITY IS FILED");
            }
            apartment.setAddress(request.address());
            apartment.setName(request.name());
            apartment.setRooms(request.rooms());
            apartmentRepository.save(apartment);
            response.setDescription("Apartment Registered");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public List<Apartment> getAllApartments() {
        return apartmentRepository.findAll();
    }
}
