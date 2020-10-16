package com.example.warehouse.stage.sourceOne.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
@Builder
public class TravelOrderStage {
    private Long id;
    private Long travelId;
    private Long clientId;
    private int numberOfSeats;
    private Date orderDate;
    private Date paymentDate;
    private Timestamp timestampFrom;
    private Timestamp timestampTo;
}
