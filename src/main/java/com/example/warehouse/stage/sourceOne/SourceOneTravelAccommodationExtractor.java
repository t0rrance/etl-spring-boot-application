package com.example.warehouse.stage.sourceOne;

import com.example.warehouse.mapper.SourceOneMapper;
import com.example.warehouse.mapper.StageMapper;
import com.example.warehouse.model.sourceOne.TravelAccommodation;
import com.example.warehouse.stage.sourceOne.model.StageTravelAccommodation;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class SourceOneTravelAccommodationExtractor {

    private SourceOneMapper sourceOneMapper;
    private StageMapper stageMapper;

    public void extractDataFromSourceToStage() {

        List<TravelAccommodation> travelAccommodationList = sourceOneMapper.selectTravelAccommodations();
        List<StageTravelAccommodation> stageTravelAccommodationList = stageMapper.selectTravelAccommodations();

        for(TravelAccommodation travelAccommodation : travelAccommodationList) {

            List<StageTravelAccommodation> stageTravelAccommodationListWithTheSameId = stageTravelAccommodationList.stream()
                    .filter(stageTravelAccommodation -> stageTravelAccommodation.getIdTravelAccommodation().equals(travelAccommodation.getId()))
                    .filter(stageTravelAccommodation -> stageTravelAccommodation.getTimestampTo() == null)
                    .collect(Collectors.toList());

            StageTravelAccommodation stageTravelAccommodation = createStageTravelAccommodation(travelAccommodation);
            stageMapper.insertStageTravelAccommodation(stageTravelAccommodation);

            if(!stageTravelAccommodationListWithTheSameId.isEmpty())
                updateTheSameObjectTimeStamp(stageTravelAccommodationListWithTheSameId, stageTravelAccommodation.getTimestampFrom());
        }
    }

    private void updateTheSameObjectTimeStamp(List<StageTravelAccommodation> stageTravelAccommodationListWithTheSameId, Timestamp timestampFrom) {
        for(StageTravelAccommodation stageTravelAccommodation : stageTravelAccommodationListWithTheSameId) {
            stageTravelAccommodation.setTimestampTo(timestampFrom);
            stageMapper.updateStageTravelAccommodation(stageTravelAccommodation);
        }
    }

    private StageTravelAccommodation createStageTravelAccommodation(TravelAccommodation travelAccommodation) {
        return StageTravelAccommodation.builder()
                .idTravelAccommodation(travelAccommodation.getId())
                .travelId(travelAccommodation.getTravelId())
                .accommodationId(travelAccommodation.getAccommodationId())
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
