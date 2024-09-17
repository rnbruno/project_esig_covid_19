package com.sideproject.starter.dao;

import java.util.List;

import com.sideproject.starter.dto.VacinationCountryTotal;
import com.sideproject.starter.dto.VacinationDateDaily;
import com.sideproject.starter.dto.VacinationMonthSummary;
import com.sideproject.starter.dto.VacinationSummaryDto;
import com.sideproject.starter.model.Vacination;

public interface VacinationDao {

    public List<Vacination> getAllVacination();

    // Método para adicionar um novo registro de vacinação
    public Vacination addVacination(Vacination vacination);

    // Novo método para inserção em massa
    void addBulkVacination(List<Vacination> vacinations);

    List<VacinationSummaryDto> getDateTotalVacination();

    List<VacinationDateDaily> getDateDailyVacination();

    List<VacinationMonthSummary> getMonthlyVacinationSummary();

    List<VacinationCountryTotal> getCountryTotalVacinationSummary();

}
