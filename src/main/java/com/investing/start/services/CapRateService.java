package com.investing.start.services;

import com.investing.start.dto.House;
import org.springframework.stereotype.Service;

@Service
public class CapRateService {
    private final NOIService noiService;
    public CapRateService(NOIService noiService) {
        this.noiService = noiService;
    }
    public double getCapRate(House house) {
        int noi = noiService.getNOI(house);
        return ((double) noi / house.homeValue()) * 100;
    }
}
