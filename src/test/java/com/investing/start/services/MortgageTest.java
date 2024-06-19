package com.investing.start.services;

import com.investing.start.dto.House;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MortgageTest {
    @Mock
    private House mockHouse;
    private MortgageService mortgageService;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        mortgageService = new MortgageService();
    }

    @ParameterizedTest
    @CsvSource({
            "200000, 20000, 5, 30, 966 ",
            "150000,10000, 4,20,848",
            "450000, 100000, 6.2, 30, 2143",
            "650000, 150000, 6, 30, 2997"
    })
    public void testGetMonthlyMortgage(int homeValue, int downPayment, double mortgageRate, int loanTerm, int expectedMonthlyMortgage) {
        when(mockHouse.homeValue()).thenReturn(homeValue);
        when(mockHouse.downPayment()).thenReturn(downPayment);
        when(mockHouse.mortgageRate()).thenReturn(mortgageRate); // Casting integer to double for mortgageRate
        when(mockHouse.loanTerm()).thenReturn(loanTerm);

        int actualMonthlyMortgage = mortgageService.getMonthlyMortgage(mockHouse);

        assertEquals(expectedMonthlyMortgage, actualMonthlyMortgage);

    }

}
