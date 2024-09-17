package com.sideproject.starter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sideproject.starter.dao.VacinationDao;
import com.sideproject.starter.dto.VacinationCountryTotal;
import com.sideproject.starter.dto.VacinationDateDaily;
import com.sideproject.starter.dto.VacinationMonthSummary;
import com.sideproject.starter.dto.VacinationSummaryDto;
import com.sideproject.starter.model.Vacination;

@RestController
@RequestMapping("/api/vacinations")
public class VacinationController {

    private VacinationDao vacinationDao;

    public VacinationController(VacinationDao vacinationDao) {
        this.vacinationDao = vacinationDao;
    }

    @GetMapping("/all")
    public List<Vacination> getAllVacination() {
        List<Vacination> vacinationsList = new ArrayList<>();
        vacinationsList = vacinationDao.getAllVacination();
        if (vacinationsList == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vacinations List Not Found");
        } else {
            return vacinationsList;
        }
    }

    @PostMapping
    public Vacination addVacination(@RequestBody Vacination vacination) {
        return vacinationDao.addVacination(vacination);
    }

    @PostMapping("/bulk")
    public ResponseEntity<Void> addBulkVacination(@RequestBody List<Vacination> vacinations) {
        vacinationDao.addBulkVacination(vacinations);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/dateTotalVacination")
    public ResponseEntity<List<VacinationSummaryDto>> getDateTotalVacination() {
        List<VacinationSummaryDto> summary = vacinationDao.getDateTotalVacination();
        return ResponseEntity.ok(summary);
    }

    @GetMapping("/dateDailyVacination")
    public ResponseEntity<List<VacinationDateDaily>> getDateDailyVacination() {
        List<VacinationDateDaily> summary = vacinationDao.getDateDailyVacination();
        return ResponseEntity.ok(summary);
    }

    @GetMapping("/dateMonthVacination")
    public ResponseEntity<List<VacinationMonthSummary>> getMonthlyVacinationSummary() {
        List<VacinationMonthSummary> summary = vacinationDao.getMonthlyVacinationSummary();
        return ResponseEntity.ok(summary);
    }

    @GetMapping("/dateTotalPerContry")
    public ResponseEntity<List<VacinationCountryTotal>> getCountryTotalVacinationSummary() {
        List<VacinationCountryTotal> summary = vacinationDao.getCountryTotalVacinationSummary();
        return ResponseEntity.ok(summary);
    }
}
