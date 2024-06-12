package com.investing.start.controllers;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    ExternalApiController externalApiController;
    public HomeController(ExternalApiController externalApiController) {
        this.externalApiController = externalApiController;
    }
    @GetMapping("/home")
    public ResponseEntity<String> sendAddressData(@RequestParam(name="address") String address) {
        log.info("entered HomeController.sendAddressData");
        log.info("address is: {}", address);
        Map<String,Object> data = externalApiController.getHouseData(address);
        return ResponseEntity.ok().body(data.toString());
    }
}
