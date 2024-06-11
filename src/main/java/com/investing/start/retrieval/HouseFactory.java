package com.investing.start.retrieval;

import org.springframework.stereotype.Component;

@Component
public class HouseFactory {
    public House createHouse(int homeValue,
                             int rentValue,
                             int downPayment,
                             int mortgageRate,
                             float propertyTaxPercent,
                             int insurance,
                             int appreciation,
                             int otherExpenses) {
        return new House(homeValue, rentValue, downPayment, mortgageRate, propertyTaxPercent, insurance, appreciation, otherExpenses);

    }
}
