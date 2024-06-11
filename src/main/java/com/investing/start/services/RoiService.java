package com.investing.start.services;
import com.investing.start.retrieval.House;
import org.springframework.stereotype.Service;
//double totalRevenue, double totalExpenses, double totalInvestment
@Service
public class RoiService {
    public int calculateROI(House house, NOIService noiService, MortgageService mortgageService) {
        int annualRent = noiService.calculateNOI(house);
        int annualMortgage = mortgageService.calculateMonthlyMortgage(house);
        int closingCosts = (int) (house.homeValue() * 0.05); //average closing cost is around 5%
        int totalInvestment = house.downPayment() + closingCosts;
        return (annualRent - annualMortgage) / totalInvestment;
    }
}
