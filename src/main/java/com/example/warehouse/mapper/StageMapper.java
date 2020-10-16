package com.example.warehouse.mapper;

import com.example.warehouse.stage.sourceOne.model.AccommodationStage;
import com.example.warehouse.stage.sourceOne.model.ClientStage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StageMapper {

    void insertAccommodationStage(@Param("accommodationStage") AccommodationStage accommodationStage);

    List<AccommodationStage> selectAccommodationsAll();

    void updateAccommodateStage(@Param("accommodationStage") AccommodationStage accommodationStage);

    List<ClientStage> selectClientAll();

}
