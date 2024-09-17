package com.sideproject.starter.dto;

public class VacinationCountryTotal {
    private String country;
    private double totalVaccinations;

    // Getter para o campo country
    public String getCountry() {
        return country;
    }

    // Setter para o campo country
    public void setCountry(String country) {
        this.country = country;
    }

    // Getter para o campo totalVaccinations
    public double getTotalVaccinations() {
        return totalVaccinations;
    }

    // Setter para o campo totalVaccinations
    public void setTotalVaccinations(double totalVaccinations) {
        this.totalVaccinations = totalVaccinations;
    }
}
