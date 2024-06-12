package com.investing.start.services;
import com.investing.start.dto.House;
import org.springframework.stereotype.Service;
//Cash on Cash Return or Cash ROI
@Service
public class RoiService {
    public int calculateROI(House house, NOIService noiService, MortgageService mortgageService) {

        int annualRent = noiService.getNOI(house);

        int annualMortgage = mortgageService.getMonthlyMortgage(house);

        int closingCosts = (int) (house.homeValue() * 0.05); //average closing cost is around 5%

        int totalInvestment = house.downPayment() + closingCosts;

        return (annualRent - annualMortgage) / totalInvestment;
    }
}
