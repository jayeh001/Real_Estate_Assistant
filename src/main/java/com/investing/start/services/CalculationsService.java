package com.investing.start.services;

import com.investing.start.dto.HouseFactory;
import org.springframework.stereotype.Service;
//NOI, ROI, capitalization rate, monthly cash flow, cash on cash return
@Service
public class CalculationsService {

    HouseFactory houseFactory;

    RoiService roiService;

    public CalculationsService(HouseFactory houseFactory, RoiService roiService) {
        this.houseFactory = houseFactory;
        this.roiService = roiService;
    }
}