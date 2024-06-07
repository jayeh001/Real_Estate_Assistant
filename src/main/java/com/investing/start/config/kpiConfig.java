package com.investing.start.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "kpi")
public class kpiConfig {
    private int roi;
    private int cashOnCash;

    public int getRoi() {
        return roi;
    }
    public int getCashOnCash() {
        return cashOnCash;
    }
    public void setRoi(int roi) {
        this.roi = roi;
    }
    public void setCashOnCash(int cashOnCash) {
        this.cashOnCash = cashOnCash;
    }
}
