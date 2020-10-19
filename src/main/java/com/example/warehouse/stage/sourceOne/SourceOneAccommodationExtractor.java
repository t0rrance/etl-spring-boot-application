package com.example.warehouse.stage.sourceOne;

import com.example.warehouse.mapper.SourceOneMapper;
import com.example.warehouse.mapper.StageMapper;
import com.example.warehouse.model.sourceOne.Accommodation;
import com.example.warehouse.stage.sourceOne.model.StageAccommodation;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class SourceOneAccommodationExtractor {

    private  SourceOneMapper sourceOneMapper;
    private  StageMapper stageMapper;

    public void extractDataFromSourceToStage() {

        List<Accommodation> accommodationList = sourceOneMapper.selectAccommodations();
        List<StageAccommodation> accommodationStageList = stageMapper.selectStageAccommodations();

        for (Accommodation accommodation : accommodationList) {

            List<StageAccommodation> listContainsObjectsTheSameKey = accommodationStageList.stream()
                    .filter(stageAccommodation -> stageAccommodation.getIdAccommodation().equals(accommodation.getId()))
                    .filter(stageAccommodation -> stageAccommodation.getTimestampTo() == null)
                    .collect(Collectors.toList());

           StageAccommodation stageAccommodation = createObjectStage(accommodation);
           stageMapper.insertStageAccommodation(stageAccommodation);

           if(!listContainsObjectsTheSameKey.isEmpty())
               updateTheSameObjectTimeStamp(listContainsObjectsTheSameKey, stageAccommodation.getTimestampFrom());

        }

    }

    private void updateTheSameObjectTimeStamp(List<StageAccommodation> listContainsTheSameObjects, Timestamp timestampFrom) {

        for (var itemList : listContainsTheSameObjects) {
            itemList.setTimestampTo(timestampFrom);
            stageMapper.updateStageAccommodation(itemList);
        }

    }

    private StageAccommodation createObjectStage(Accommodation accommodation) {
        return StageAccommodation.builder()
                .idAccommodation(accommodation.getId())
                .typeAccommodation(accommodation.getTypeAccommodation())
                .address(accommodation.getAddress())
                .pricePerDay(accommodation.getPricePerDay())
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
