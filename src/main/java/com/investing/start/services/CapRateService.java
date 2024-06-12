package com.investing.start.services;

import com.investing.start.dto.House;
import org.springframework.stereotype.Service;

@Service
public class CapRateService {
    public int getCapRate(House house, NOIService noiService) {
        int noi = noiService.getNOI(house);
        return (noi / house.homeValue()) * 100;
    }
}
