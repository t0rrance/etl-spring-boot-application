package com.example.warehouse.model.sourceOne;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TravelAccommodation {
    private Long id;
    private Long travelId;
    private Long accommodationId;
}
