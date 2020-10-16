package com.example.warehouse.stage.sourceOne.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
@Builder
public class TravelStage {
    private Long id;
    private String travelName;
    private int numberOfSeats;
    private int numberOccupiedSeats;
    private int pricePerSeat;
    private Date startDate;
    private Date finishDate;
    private Timestamp timestampFrom;
    private Timestamp timestampTo;
}
