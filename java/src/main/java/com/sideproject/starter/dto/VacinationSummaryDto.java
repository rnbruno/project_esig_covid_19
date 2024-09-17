package com.sideproject.starter.dto;

import java.time.LocalDate;

public class VacinationSummaryDto {
    private LocalDate date;
    private double totalVaccinations;

    // Getters e Setters
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalVaccinations() {
        return totalVaccinations;
    }

    public void setTotalVaccinations(double totalVaccinations) {
        this.totalVaccinations = totalVaccinations;
    }
}
