package com.Property.management.Property.Management.Service.Repository;

import com.Property.management.Property.Management.Service.Model.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BusinessRepository extends JpaRepository<Business,Long> {
    @Query(value = "select * from business where business.email = ?1", nativeQuery = true)
    Optional<Business> findByEmail(String email);

}
