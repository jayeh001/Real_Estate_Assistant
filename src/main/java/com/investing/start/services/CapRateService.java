package com.investing.start.services;

import com.investing.start.dto.House;
import org.springframework.stereotype.Service;

@Service
public class CapRateService {
    private final NOIService noiService;
    public CapRateService(NOIService noiService) {
        this.noiService = noiService;
    }
    public int getCapRate(House house) {
        int noi = noiService.getNOI(house);
        return (noi / house.homeValue()) * 100;
    }
}
