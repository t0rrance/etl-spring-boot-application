package com.example.warehouse.model.sourceOne;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Client {
    private Long id;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String address;
}
