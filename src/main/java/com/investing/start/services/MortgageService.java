package com.investing.start.services;

import com.investing.start.dto.House;
import org.springframework.stereotype.Service;

@Service
public class MortgageService {
    public int getMonthlyMortgage(House house) {

        if (house.downPayment() == house.homeValue()) {
            return 0;
        }

        double monthlyMortRate = (double) house.mortgageRate() / (12 * 100);

        double totalPayments = (double) house.loanTerm() * 12;

        double principal = house.homeValue() - house.downPayment();

        double constantVar = (double) Math.pow((1 + monthlyMortRate),totalPayments);

        return (int) (principal * ((monthlyMortRate * constantVar) / (constantVar - 1)));
    }
}
