package com.example.warehouse.service;

import com.example.warehouse.stage.sourceOne.SourceOneAccommodationExtractor;
import lombok.Data;

@Data
public class ExtractService {

    private SourceOneAccommodationExtractor sourceOneAccommodationExtractor;

    public void extract() {
        sourceOneAccommodationExtractor.extractDataFromSourceToStage();
    }

    public SourceOneAccommodationExtractor getSourceOneAccommodationExtractor() {
        return sourceOneAccommodationExtractor;
    }

    public void setSourceOneAccommodationExtractor(SourceOneAccommodationExtractor sourceOneAccommodationExtractor) {
        this.sourceOneAccommodationExtractor = sourceOneAccommodationExtractor;
    }

}
