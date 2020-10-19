package com.example.warehouse.stage.sourceOne.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class StageAccommodation {
    private Long id;
    private Long idAccommodation;
    private String typeAccommodation;
    private String address;
    private int pricePerDay;
    private Timestamp timestampFrom;
    private Timestamp timestampTo;
}
