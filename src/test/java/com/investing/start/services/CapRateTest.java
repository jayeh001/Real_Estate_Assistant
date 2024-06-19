package com.investing.start.services;

import com.investing.start.dto.House;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CapRateTest {
    @Mock
    private NOIService noiService;
    @Mock
    private House mockHouse;

    @InjectMocks
    private CapRateService capRateService;

    @BeforeEach
    public void setUp() {
        //MockitoAnnotations.openMocks(this);

    }
    @Test
    public void testCapRate() {
        when(noiService.getNOI(mockHouse)).thenReturn(2100);
        when(mockHouse.homeValue()).thenReturn(400000);

        double capRate = capRateService.getCapRate(mockHouse);

        assertEquals(100.0,capRate);
    }
}
