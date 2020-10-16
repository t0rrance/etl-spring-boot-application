package com.example.warehouse.model.sourceOne;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TravelOrder {
    private Long id;
    private Long travelId;
    private Long clientId;
    private int numberOfSeats;
    private Date orderDate;
    private Date paymentDate;
}
