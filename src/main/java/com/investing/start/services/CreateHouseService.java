package com.investing.start.services;

import com.investing.start.dto.House;
import com.investing.start.dto.HouseFactory;
import org.springframework.stereotype.Service;

@Service
public class CreateHouseService {
    private final HouseFactory houseFactory;

    public CreateHouseService(HouseFactory houseFactory) {
        this.houseFactory = houseFactory;
    }
// react.js front end should have initial values established
    public House generateHouse(int homeValue,
                                      int rentValue,
                                      int downPayment,
                                      int loanTerm,
                                      int mortgageRate,
                                      double propertyTaxPercent,
                                      int insurance,
                                      int appreciation,
                                      int otherExpenses) {
        return houseFactory.createHouse(homeValue, rentValue, downPayment, loanTerm, mortgageRate, propertyTaxPercent, insurance, appreciation, otherExpenses);
    }
}
