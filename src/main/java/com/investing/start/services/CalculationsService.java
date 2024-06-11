package com.investing.start.services;

import com.investing.start.retrieval.HouseFactory;
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
//TODO: YO I SHOULD ACTUALLY CREATE THE HOUSE IN CREATEHOUSEFROMUSERINPUT BECAUSE IT CAN DYNAMICALLY ASSIGN THE VALUES
//BASED ON USER INPUT OR DEFAULTS AND THEN PLUG THE CREATEHOUSEFROMINPUT COMPONENT INTO CALCULATIONSSERVICE