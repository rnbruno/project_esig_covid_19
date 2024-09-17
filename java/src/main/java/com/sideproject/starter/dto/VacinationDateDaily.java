package com.sideproject.starter.dto;

import java.time.LocalDate;

public class VacinationDateDaily {
    private LocalDate date;
    private double dailyVaccinations;

    // Getters e Setters
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getDailyVaccinations() {
        return dailyVaccinations;
    }

    public void setDailyVaccinations(Double dailyVaccinations) {
        this.dailyVaccinations = dailyVaccinations;
    }
}
