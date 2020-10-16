package com.example.warehouse.mapper;

import com.example.warehouse.model.sourceOne.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SourceOneMapper {

    List<Accommodation> selectAccommodations();
    List<Client> selectClients();
    List<Travel> selectTravels();
    List<TravelOrder> selectTravelOrders();
    List<TravelAccommodation> selectTravelAccommodations();

}
