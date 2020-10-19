package com.example.warehouse.stage.sourceOne;

import com.example.warehouse.mapper.SourceOneMapper;
import com.example.warehouse.mapper.StageMapper;
import com.example.warehouse.model.sourceOne.Travel;
import com.example.warehouse.stage.sourceOne.model.StageTravel;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SourceOneTravelExtractor {

    private SourceOneMapper sourceOneMapper;
    private StageMapper stageMapper;


    public void extractDataFromSourceToStage() {

        List<Travel> travelList = sourceOneMapper.selectTravels();
        List<StageTravel> stageTravelList = stageMapper.selectStageTravels();

        for(Travel travel : travelList) {

            List<StageTravel> stageTravelListWithTheSame = stageTravelList.stream()
                    .filter(stageTravel -> stageTravel.getIdTravel().equals(travel.getId()))
                    .filter(stageTravel -> stageTravel.getTimestampTo() == null)
                    .collect(Collectors.toList());

            StageTravel stageTravel = createStageTravel(travel);
            stageMapper.insertStageTravel(stageTravel);

            if(!stageTravelListWithTheSame.isEmpty()) {
                updateTravelTheSameList(stageTravelListWithTheSame, stageTravel.getTimestampFrom());
            }

        }

    }

    private void updateTravelTheSameList(List<StageTravel> stageTravelListWithTheSame, Timestamp timestampFrom) {

        for(StageTravel stageTravel:stageTravelListWithTheSame) {
            stageTravel.setTimestampTo(timestampFrom);
            stageMapper.updateStageTravel(stageTravel);
        }

    }

    private StageTravel createStageTravel(Travel travel) {
        return StageTravel.builder()
                .idTravel(travel.getId())
                .travelName(travel.getTravelName())
                .numberOfSeats(travel.getNumberOfSeats())
                .numberOccupiedSeats(travel.getNumberOccupiedSeats())
                .pricePerSeat(travel.getPricePerSeat())
                .startDate(travel.getStartDate())
                .finishDate(travel.getFinishDate())
                .timestampFrom(new Timestamp(System.currentTimeMillis()))
                .timestampTo(null)
                .build();
    }

    public void setSourceOneMapper(SourceOneMapper sourceOneMapper) {
        this.sourceOneMapper = sourceOneMapper;
    }

    public void setStageMapper(StageMapper stageMapper) {
        this.stageMapper = stageMapper;
    }

}
