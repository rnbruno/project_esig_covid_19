package com.sideproject.starter.dto;

import java.time.LocalDate;

public class VacinationMonthSummary {
    private LocalDate monthStart;
    private String yearMonth;
    private double totalVaccinations;

    // Getters e Setters
    public LocalDate getMonthStart() {
        return monthStart;
    }

    public void setMonthStart(LocalDate monthStart) {
        this.monthStart = monthStart;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public double getTotalVaccinations() {
        return totalVaccinations;
    }

    public void setTotalVaccinations(double totalVaccinations) {
        this.totalVaccinations = totalVaccinations;
    }
}
