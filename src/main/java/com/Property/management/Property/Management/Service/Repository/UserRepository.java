package com.Property.management.Property.Management.Service.Repository;

import com.Property.management.Property.Management.Service.Model.NewUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<NewUser,Long> {
    Optional<NewUser> findByEmail(String email);
}
