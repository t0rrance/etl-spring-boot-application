package com.example.warehouse.stage.sourceOne;

import com.example.warehouse.mapper.SourceOneMapper;
import com.example.warehouse.mapper.StageMapper;
import com.example.warehouse.model.sourceOne.Accommodation;
import com.example.warehouse.stage.sourceOne.model.AccommodationStage;
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
        List<AccommodationStage> accommodationStageList = stageMapper.selectAccommodationsAll();

        for (Accommodation accommodation : accommodationList) {

            List<AccommodationStage> listContainsObjectsTheSameKey = accommodationStageList.stream().filter(stageObject -> stageObject.getId().equals(accommodation.getId())).collect(Collectors.toList());

            if (!listContainsObjectsTheSameKey.isEmpty()) {
                updateTheSameObjectTimeStamp(listContainsObjectsTheSameKey);
                AccommodationStage accommodationStage = createObjectStage(accommodation, listContainsObjectsTheSameKey.get(0).getTimestampTo());
                stageMapper.insertAccommodationStage(accommodationStage);
            } else {
                AccommodationStage accommodationStage = createObjectStage(accommodation);
                stageMapper.insertAccommodationStage(accommodationStage);
            }

        }

    }

    private void updateTheSameObjectTimeStamp(List<AccommodationStage> listContainsTheSameObjects) {

        for (var itemList : listContainsTheSameObjects) {
            itemList.setTimestampTo(new Timestamp(System.currentTimeMillis()));
            stageMapper.updateAccommodateStage(itemList);
        }

    }

    private AccommodationStage createObjectStage(Accommodation accommodation) {
        return AccommodationStage.builder()
                .typeAccommodation(accommodation.getTypeAccommodation())
                .address(accommodation.getAddress())
                .pricePerDay(accommodation.getPricePerDay())
                .timestampFrom(new Timestamp(System.currentTimeMillis()))
                .timestampTo(null)
                .build();
    }

    private AccommodationStage createObjectStage(Accommodation accommodation, Timestamp startTimestampFromFinishTheSame) {
        return AccommodationStage.builder()
                .typeAccommodation(accommodation.getTypeAccommodation())
                .address(accommodation.getAddress())
                .pricePerDay(accommodation.getPricePerDay())
                .timestampFrom(startTimestampFromFinishTheSame)
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
