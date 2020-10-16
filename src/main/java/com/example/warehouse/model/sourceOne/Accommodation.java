package com.example.warehouse.model.sourceOne;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Accommodation {
    private Long id;
    private String typeAccommodation;
    private String address;
    private int pricePerDay;
}
