package com.investing.start.services;

import com.investing.start.dto.HouseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateHouseFromUserInputService {
    private final HouseFactory houseFactory;
    @Autowired
    public CreateHouseFromUserInputService(HouseFactory houseFactory) {
        this.houseFactory = houseFactory;
    }
    //public House generateHouse(int )
}
