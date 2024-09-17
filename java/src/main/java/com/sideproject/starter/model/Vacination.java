package com.sideproject.starter.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
// import javax.persistence.*;
// import org.springframework.data.annotation.Id;
// import org.springframework.data.relational.core.mapping.Table;
// import org.springframework.data.relational.core.mapping.Column;

public class Vacination {

    private Double id;
    private String country;
    private String iso_code;

    private LocalDate date;

    // @Column(name = "total_vaccinations")
    private Double total_vaccinations;

    private Double people_vaccinated;
    private Double people_fully_vaccinated;
    private Double daily_vaccinations_raw;
    private Double daily_vaccinations;
    private Double total_vaccinations_per_hundred;
    private Double people_vaccinated_per_hundred;
    private Double people_fully_vaccinated_per_hundred;
    private Double daily_vaccinations_per_million;
    private String vaccines;
    private String source_name;
    private String source_website;
    private LocalDateTime data_registro;

    // Getters and Setters
    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIsoCode() {
        return iso_code;
    }

    public void setIsoCode(String iso_code) {
        this.iso_code = iso_code;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotalVaccinations() {
        return total_vaccinations;
    }

    public void setTotalVaccinations(Double total_vaccinations) {
        this.total_vaccinations = total_vaccinations;
    }

    public Double getPeopleVaccinated() {
        return people_vaccinated;
    }

    public void setPeopleVaccinated(Double people_vaccinated) {
        this.people_vaccinated = people_vaccinated;
    }

    public Double getPeopleFullyVaccinated() {
        return people_fully_vaccinated;
    }

    public void setPeopleFullyVaccinated(Double people_fully_vaccinated) {
        this.people_fully_vaccinated = people_fully_vaccinated;
    }

    public Double getDailyVaccinationsRaw() {
        return daily_vaccinations_raw;
    }

    public void setDailyVaccinationsRaw(Double daily_vaccinations_raw) {
        this.daily_vaccinations_raw = daily_vaccinations_raw;
    }

    public Double getDailyVaccinations() {
        return daily_vaccinations;
    }

    public void setDailyVaccinations(Double daily_vaccinations) {
        this.daily_vaccinations = daily_vaccinations;
    }

    public Double getTotalVaccinationsPerHundred() {
        return total_vaccinations_per_hundred;
    }

    public void setTotalVaccinationsPerHundred(Double total_vaccinations_per_hundred) {
        this.total_vaccinations_per_hundred = total_vaccinations_per_hundred;
    }

    public Double getPeopleVaccinatedPerHundred() {
        return people_vaccinated_per_hundred;
    }

    public void setPeopleVaccinatedPerHundred(Double people_vaccinated_per_hundred) {
        this.people_vaccinated_per_hundred = people_vaccinated_per_hundred;
    }

    public Double getPeopleFullyVaccinatedPerHundred() {
        return people_fully_vaccinated_per_hundred;
    }

    public void setPeopleFullyVaccinatedPerHundred(Double people_fully_vaccinated_per_hundred) {
        this.people_fully_vaccinated_per_hundred = people_fully_vaccinated_per_hundred;
    }

    public Double getDailyVaccinationsPerMillion() {
        return daily_vaccinations_per_million;
    }

    public void setDailyVaccinationsPerMillion(Double daily_vaccinations_per_million) {
        this.daily_vaccinations_per_million = daily_vaccinations_per_million;
    }

    public String getVaccines() {
        return vaccines;
    }

    public void setVaccines(String vaccines) {
        this.vaccines = vaccines;
    }

    public String getSourceName() {
        return source_name;
    }

    public void setSourceName(String source_name) {
        this.source_name = source_name;
    }

    public String getSourceWebsite() {
        return source_website;
    }

    public void setSourceWebsite(String source_website) {
        this.source_website = source_website;
    }

    public LocalDateTime getDateRegistro() {
        return data_registro;
    }

    public void setDateRegistro(LocalDateTime data_registro) {
        this.data_registro = data_registro;
    }
}
