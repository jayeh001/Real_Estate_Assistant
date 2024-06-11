package com.investing.start.services;

import com.investing.start.retrieval.House;
import org.springframework.stereotype.Service;

@Service
public class MortgageService {
    public int calculateMonthlyMortgage(House house) {
        float monthlyMortRate = (float) house.mortgageRate() / (12 * 100);
        float totalPayments = (float) house.loanTerm() * 12;
        float principal = house.homeValue() - house.downPayment();
        float constantVar = (float) Math.pow((1 + monthlyMortRate),totalPayments);
        return (int) (principal * ((monthlyMortRate * constantVar) / (constantVar - 1)));
    }
}
