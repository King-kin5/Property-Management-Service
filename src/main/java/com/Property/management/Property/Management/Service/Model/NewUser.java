package com.Property.management.Property.Management.Service.Model;

import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Registered_Users")
public class NewUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    @NaturalId(mutable = true)
    private String email;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "Address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "password")
    private String password;
    private LocalDateTime lastLogin;
}
