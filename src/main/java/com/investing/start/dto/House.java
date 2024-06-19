package com.investing.start.dto;


//public class House {
//    int value;
//    public House(int value) {
//        this.value = value;
//    }
//}
public record House(
        int homeValue,
        int rentValue,
        int downPayment,
        int loanTerm,
        double mortgageRate,
        double propertyTaxPercent,
        int insurance,
        int appreciation,
        int otherExpenses
) { }
