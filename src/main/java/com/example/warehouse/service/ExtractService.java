package com.example.warehouse.service;

import com.example.warehouse.stage.sourceOne.SourceOneAccommodationExtractor;
import com.example.warehouse.stage.sourceOne.SourceOneTravelAccommodationExtractor;
import com.example.warehouse.stage.sourceOne.SourceOneTravelExtractor;
import lombok.Data;

@Data
public class ExtractService {

    private SourceOneAccommodationExtractor sourceOneAccommodationExtractor;
    private SourceOneTravelAccommodationExtractor sourceOneTravelAccommodationExtractor;
    private SourceOneTravelExtractor sourceOneTravelExtractor;

    public void extract() {

        sourceOneAccommodationExtractor.extractDataFromSourceToStage();
        sourceOneTravelExtractor.extractDataFromSourceToStage();
        sourceOneTravelAccommodationExtractor.extractDataFromSourceToStage();

    }

    public void setSourceOneAccommodationExtractor(SourceOneAccommodationExtractor sourceOneAccommodationExtractor) {
        this.sourceOneAccommodationExtractor = sourceOneAccommodationExtractor;
    }

    public void setSourceOneTravelExtractor(SourceOneTravelExtractor sourceOneTravelExtractor) {
        this.sourceOneTravelExtractor = sourceOneTravelExtractor;
    }

    public void setSourceOneTravelAccommodationExtractor(SourceOneTravelAccommodationExtractor sourceOneTravelAccommodationExtractor) {
        this.sourceOneTravelAccommodationExtractor = sourceOneTravelAccommodationExtractor;
    }
}
