package com.Property.management.Property.Management.Service.Repository;

import com.Property.management.Property.Management.Service.Model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApartmentRepository    extends JpaRepository<Apartment,Long> {

}
