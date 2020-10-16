package com.example.warehouse.stage.sourceOne;

import com.example.warehouse.mapper.SourceOneMapper;
import com.example.warehouse.mapper.StageMapper;
import com.example.warehouse.model.sourceOne.Client;
import com.example.warehouse.stage.sourceOne.model.ClientStage;

import java.util.List;

public class SourceOneClientExtractor {

    private SourceOneMapper sourceOneMapper;
    private StageMapper stageMapper;

    public void extractDataFromSourceToStage() {

        List<Client> clientList = sourceOneMapper.selectClients();
        List<ClientStage> clientStageList = stageMapper.selectClientAll();
    }

    public void setSourceOneMapper(SourceOneMapper sourceOneMapper) {
        this.sourceOneMapper = sourceOneMapper;
    }

    public void setStageMapper(StageMapper stageMapper) {
        this.stageMapper = stageMapper;
    }
}
