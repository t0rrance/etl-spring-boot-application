package com.example.warehouse.controller;

import com.example.warehouse.service.ExtractService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ETLController {

    private final ExtractService extractService;

    public ETLController(ExtractService sourceOneService) {
        this.extractService = sourceOneService;
    }

    @ResponseBody
    @RequestMapping("/run")
    public String runEtl() {
        extractService.extract();
        return "ok";
    }
}
