package com.investing.start.services;

import com.investing.start.dto.House;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class NOIUnitTests {
    @Mock
    private House mockHouse;
    private NOIService noiService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        noiService = new NOIService();
        when(mockHouse.rentValue()).thenReturn(1000); // Example rent value
        when(mockHouse.homeValue()).thenReturn(545454); // Example home value
        when(mockHouse.propertyTaxPercent()).thenReturn(0.02); // Example property tax percent
        when(mockHouse.insurance()).thenReturn(1500); // Example insurance value
        when(mockHouse.otherExpenses()).thenReturn(200); // Example other expenses value
    }

    @Test
    public void testNoiReturnsCorrectNoi() {
        int expectedRent = 1000 * 12;
        int expectedPropertyTaxAmount = (int) (545454 * 0.02);
        int expectedMaintenance = (int) (545454 * 0.01);
        int expectedAnnualRentIncome = (int) (expectedRent * 0.93);
        int expectedOperatingExpenses = expectedPropertyTaxAmount + 1500 + expectedMaintenance + 200;
        int expectedNOI = expectedAnnualRentIncome - expectedOperatingExpenses;

        int actualNOI = noiService.getNOI(mockHouse);
        assertEquals(expectedNOI, actualNOI);

    }
}
