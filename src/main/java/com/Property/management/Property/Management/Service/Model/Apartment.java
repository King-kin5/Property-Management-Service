package com.Property.management.Property.Management.Service.Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int id;
    private String name;
    private String address;
    private int rooms;

    public Apartment(int id,String address, String name, int rooms){
        this.id=id;
        this.address=address;
        this.name=name;
        this.rooms=rooms;

    }
}
