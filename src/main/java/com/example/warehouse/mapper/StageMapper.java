package com.example.warehouse.mapper;

import com.example.warehouse.model.sourceOne.TravelAccommodation;
import com.example.warehouse.stage.sourceOne.model.StageAccommodation;
import com.example.warehouse.stage.sourceOne.model.StageTravel;
import com.example.warehouse.stage.sourceOne.model.StageTravelAccommodation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StageMapper {

    void insertStageAccommodation(@Param("stageAccommodation") StageAccommodation stageAccommodation);

    void insertStageTravel(@Param("stageTravel") StageTravel stageTravel);

    void insertStageTravelAccommodation(@Param("stageTravelAccommodation") StageTravelAccommodation stageTravelAccommodation);

    List<StageAccommodation> selectStageAccommodations();

    List<StageTravel> selectStageTravels();

    List<StageTravelAccommodation> selectTravelAccommodations();

    void updateStageAccommodation(@Param("stageAccommodation") StageAccommodation stageAccommodation);

    void updateStageTravel(@Param("stageTravel") StageTravel stageTravel);

    void updateStageTravelAccommodation(@Param("stageTravelAccommodation") StageTravelAccommodation stageTravelAccommodation);

}
