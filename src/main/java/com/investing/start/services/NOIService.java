package com.investing.start.services;
import com.investing.start.dto.House;
import org.springframework.stereotype.Service;
//Calculate Net operating income for rental property
@Service
public class NOIService {
    public int getNOI(House house) {

        int rent = house.rentValue() * 12;

        int propertyTaxAmount = (int) (house.homeValue() * house.propertyTaxPercent());

        int maintenance = (int) (house.homeValue() * 0.01);

        //adjust annual rent by avg vacancy rate of  7 percent
        int annualRentIncome = (int) (rent * 0.93);

        int operatingExpenses = propertyTaxAmount + house.insurance() + maintenance + house.otherExpenses();

        return annualRentIncome - operatingExpenses;
    }
}
