package com.investing.start.services;
import com.investing.start.dto.House;
import org.springframework.stereotype.Service;
//Cash on Cash Return or Cash ROI
@Service
public class RoiService {

    private final NOIService noiService;

    private final MortgageService mortgageService;

    public RoiService(NOIService noiService, MortgageService mortgageService) {
        this.noiService = noiService;
        this.mortgageService = mortgageService;
    }

    public int calculateROI(House house) {
        int annualRent = noiService.getNOI(house);
        int annualMortgage = mortgageService.getMonthlyMortgage(house);
        int closingCosts = (int) (house.homeValue() * 0.05); //average closing cost is around 5%
        int totalInvestment = house.downPayment() + closingCosts;
        return (annualRent - annualMortgage) / totalInvestment;
    }
}
