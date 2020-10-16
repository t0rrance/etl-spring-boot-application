package com.example.warehouse.stage.sourceOne.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class ClientStage {
    private Long id;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String address;
    private Timestamp timestampFrom;
    private Timestamp timestampTo;
}
