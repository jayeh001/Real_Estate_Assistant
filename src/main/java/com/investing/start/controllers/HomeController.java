package com.investing.start.controllers;
import com.investing.start.dto.House;
import com.investing.start.services.CalculationsService;
import com.investing.start.services.CreateHouseService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    ExternalApiController externalApiController;

    private final CreateHouseService createHouseService;

    private final CalculationsService calculationsService;

    public HomeController(ExternalApiController externalApiController, CreateHouseService createHouseService, CalculationsService calculationsService) {
        this.externalApiController = externalApiController;
        this.createHouseService = createHouseService;
        this.calculationsService = calculationsService;
    }

    @GetMapping("/home")
    public ResponseEntity<String> getAddressData(@RequestParam(name="address") String address) {
        log.info("entered HomeController.getAddressData");
        log.info("address is: {}", address);
        Map<String,Object> data = externalApiController.getHouseData(address);
        return ResponseEntity.ok().body(data.toString());
    }

    @GetMapping("/indicators")
    public ResponseEntity<Map<String, Number>> getIndicators(
            @RequestParam(name = "homeValue") int homeValue,
            @RequestParam(name = "rentValue") int rentValue,
            @RequestParam(name = "downPayment") int downPayment,
            @RequestParam(name = "loanTerm") int loanTerm,
            @RequestParam(name = "mortgageRate") int mortgageRate,
            @RequestParam(name="propertyTaxPercent") double propertyTaxPercent,
            @RequestParam(name="insurance") int insurance,
            @RequestParam(name="appreciation") int appreciation,
            @RequestParam(name="otherExpenses") int otherExpenses
    ) {
        House house = createHouseService.generateHouse(homeValue, rentValue, downPayment, loanTerm, mortgageRate, propertyTaxPercent, insurance, appreciation, otherExpenses);
        Map<String,Number> mapping = calculationsService.calculate(house);
        return ResponseEntity.ok().body(mapping);
    }
}
