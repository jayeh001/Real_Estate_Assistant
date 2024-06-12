package com.investing.start.dto;

import org.springframework.stereotype.Component;

@Component
public class HouseFactory {
    public House createHouse(int homeValue,
                             int rentValue,
                             int downPayment,
                             int loanTerm,
                             int mortgageRate,
                             double propertyTaxPercent,
                             int insurance,
                             int appreciation,
                             int otherExpenses) {
        return new House(homeValue, rentValue, downPayment, loanTerm, mortgageRate, propertyTaxPercent, insurance, appreciation, otherExpenses);

    }
}
