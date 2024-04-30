package com.Property.management.Property.Management.Service.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "business")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String businessName;
    private String registrationNumber;
    private String email;
    private String address;
    private String phoneNumber;
    private String password;
    private boolean enabled;
    private String country;

}
