package com.Property.management.Property.Management.Service.Request;

import java.time.LocalDateTime;

public record ApartmentRequest(
         String name,
         String address,
         Long rooms,
         LocalDateTime endDate
) {
}
