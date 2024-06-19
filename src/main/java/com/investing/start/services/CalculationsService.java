package com.investing.start.services;

import com.investing.start.dto.House;
import com.investing.start.dto.HouseFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

//NOI, ROI, capitalization rate, monthly cash flow, cash on cash return
@Service
public class CalculationsService {

    private final RoiService roiService;

    private NOIService noiService;

    private CapRateService capRateService;

    public CalculationsService( RoiService roiService) {
        this.roiService = roiService;
    }

    public Map<String, Number> calculate(House house) {
        Map<String, Number> map = new HashMap<>();
        map.put("caprate", capRateService.getCapRate(house));
        map.put("noi", noiService.getNOI(house));
        map.put("roi", roiService.calculateROI(house));
        return map;
    }
}