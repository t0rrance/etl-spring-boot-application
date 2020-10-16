package com.example.warehouse.stage.sourceOne.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class TravelAccommodationStage {
    private Long travelId;
    private Long accommodationId;
    private Timestamp timestampFrom;
    private Timestamp timestampTo;
}
