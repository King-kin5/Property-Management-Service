package com.Property.management.Property.Management.Service.Service;

import com.Property.management.Property.Management.Service.Repository.ApartmentRepository;
import com.Property.management.Property.Management.Service.Model.Apartment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;

    public Apartment registerApartment(Apartment apartment) {
        return apartmentRepository.save(apartment);
    }

    public List<Apartment> getAllApartments() {
        return apartmentRepository.findAll();
    }
}
