package com.Property.management.Property.Management.Service.Service;

import com.Property.management.Property.Management.Service.Repository.ApartmentRepository;
import com.Property.management.Property.Management.Service.Model.Apartment;
import com.Property.management.Property.Management.Service.Request.ApartmentRequest;
import com.Property.management.Property.Management.Service.Response.ApartmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;

    public ApartmentResponse registerApartment(ApartmentRequest request) {
        Apartment apartment=new Apartment();
        ApartmentResponse response=new ApartmentResponse();
        try {
            if (request.address() == null || request.address().isEmpty() ||
                    request.name() == null || request.name().isEmpty()) {
                response.setDescription("MAKE SURE ALL FIELDS ARE FILLED");
                return response;
            }

            apartment.setAddress(request.address());
            apartment.setName(request.name());
            apartment.setRooms(request.rooms());
            apartment.setAvailable(true);
            apartment.setOccupied(false);

            apartmentRepository.save(apartment);
            response.setDescription("Apartment Registered");
        } catch (Exception e) {
            e.printStackTrace();
            response.setDescription("An error occurred during registration");
        }

        return response;
    }

    public List<Apartment> getAllApartments() {
        return apartmentRepository.findAll();
    }

    public ApartmentResponse rentApartment(Long apartmentId, ApartmentRequest request) {
        Apartment apartment = apartmentRepository.findById(apartmentId).orElse(null);
        ApartmentResponse response = new ApartmentResponse();
        if (apartment != null && apartment.isAvailable()) {
            apartment.setOccupied(true);
            apartment.setAvailable(false);
            apartment.setEndDate(request.endDate());
            apartmentRepository.save(apartment);
            response.setDescription("Apartment rented successfully");
        } else if (apartment != null && !apartment.isAvailable()) {
            response.setDescription("Apartment is not available");
        } else {
            response.setDescription("Apartment not found");
        }
        return response;
    }







}
