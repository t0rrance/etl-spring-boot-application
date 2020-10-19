package com.example.warehouse.stage.sourceOne.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class StageTravelAccommodation {
    private Long id;
    private Long idTravelAccommodation;
    private Long travelId;
    private Long accommodationId;
    private Timestamp timestampFrom;
    private Timestamp timestampTo;
}
