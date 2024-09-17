package com.sideproject.starter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.sideproject.starter.dto.VacinationCountryTotal;
import com.sideproject.starter.dto.VacinationDateDaily;
import com.sideproject.starter.dto.VacinationMonthSummary;
import com.sideproject.starter.dto.VacinationSummaryDto;
import com.sideproject.starter.exception.DaoException;
import com.sideproject.starter.model.Vacination;

@Component
public class JdbcVacinationDao implements VacinationDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcVacinationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void createTablesIfNotExist() {
        String sql = "CREATE TABLE IF NOT EXISTS vaccinations (" +
                "id SERIAL PRIMARY KEY, " +
                "country VARCHAR(255), " +
                "iso_code VARCHAR(255), " +
                "date DATE, " +
                "total_vaccinations FLOAT, " +
                "people_vaccinated FLOAT, " +
                "people_fully_vaccinated FLOAT, " +
                "daily_vaccinations_raw FLOAT, " +
                "daily_vaccinations FLOAT, " +
                "total_vaccinations_per_hundred FLOAT, " +
                "people_vaccinated_per_hundred FLOAT, " +
                "people_fully_vaccinated_per_hundred FLOAT, " +
                "daily_vaccinations_per_million FLOAT, " +
                "vaccines TEXT, " +
                "source_name TEXT, " +
                "source_website TEXT, " +
                "data_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ")";
        jdbcTemplate.execute(sql);
    }

    @Override
    public List<Vacination> getAllVacination() {
        List<Vacination> vacinationList = new ArrayList<>();
        String sql = "SELECT * FROM vaccinations";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                vacinationList.add(mapRowsToVacination(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to the database");
        }
        return vacinationList;
    }

    public Vacination mapRowsToVacination(SqlRowSet rowSet) {
        Vacination vacination = new Vacination();
        // Mapeando os campos do banco de dados para o objeto Vacination
        vacination.setCountry(rowSet.getString("country"));
        vacination.setIsoCode(rowSet.getString("iso_code"));
        vacination.setDate(rowSet.getDate("date").toLocalDate()); // Assumindo que o campo date seja do tipo LocalDate
        vacination.setTotalVaccinations(rowSet.getDouble("total_vaccinations"));
        vacination.setPeopleVaccinated(rowSet.getDouble("people_vaccinated"));
        vacination.setPeopleFullyVaccinated(rowSet.getDouble("people_fully_vaccinated"));
        vacination.setDailyVaccinationsRaw(rowSet.getDouble("daily_vaccinations_raw"));
        vacination.setDailyVaccinations(rowSet.getDouble("daily_vaccinations"));
        vacination.setTotalVaccinationsPerHundred(rowSet.getDouble("total_vaccinations_per_hundred"));
        vacination.setPeopleVaccinatedPerHundred(rowSet.getDouble("people_vaccinated_per_hundred"));
        vacination.setPeopleFullyVaccinatedPerHundred(rowSet.getDouble("people_fully_vaccinated_per_hundred"));
        vacination.setDailyVaccinationsPerMillion(rowSet.getDouble("daily_vaccinations_per_million"));
        vacination.setVaccines(rowSet.getString("vaccines"));
        vacination.setSourceName(rowSet.getString("source_name"));
        vacination.setSourceWebsite(rowSet.getString("source_website"));
        return vacination;
    }

    @Override
    public Vacination addVacination(Vacination vacination) {
        String sql = "INSERT INTO vaccinations (country, iso_code, date, total_vaccinations, " +
                "people_vaccinated, people_fully_vaccinated, daily_vaccinations_raw, daily_vaccinations, " +
                "total_vaccinations_per_hundred, people_vaccinated_per_hundred, people_fully_vaccinated_per_hundred, " +
                "daily_vaccinations_per_million, vaccines, source_name, source_website) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                vacination.getCountry(), vacination.getIsoCode(), vacination.getDate(),
                vacination.getTotalVaccinations(), vacination.getPeopleVaccinated(),
                vacination.getPeopleFullyVaccinated(), vacination.getDailyVaccinationsRaw(),
                vacination.getDailyVaccinations(), vacination.getTotalVaccinationsPerHundred(),
                vacination.getPeopleVaccinatedPerHundred(), vacination.getPeopleFullyVaccinatedPerHundred(),
                vacination.getDailyVaccinationsPerMillion(), vacination.getVaccines(),
                vacination.getSourceName(), vacination.getSourceWebsite());

        // Se necessário, retorne o objeto Vacination inserido
        return vacination; // Ajuste conforme necessário
    }

    @Override
    public void addBulkVacination(List<Vacination> vacinations) {
        String deleteSql = "DELETE FROM vaccinations";
        jdbcTemplate.update(deleteSql);

        String sql = "INSERT INTO vaccinations (country, iso_code, date, total_vaccinations, " +
                "people_vaccinated, people_fully_vaccinated, daily_vaccinations_raw, daily_vaccinations, " +
                "total_vaccinations_per_hundred, people_vaccinated_per_hundred, people_fully_vaccinated_per_hundred, " +
                "daily_vaccinations_per_million, vaccines, source_name, source_website) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        for (Vacination vacination : vacinations) {

            jdbcTemplate.update(sql,
                    vacination.getCountry() != null ? vacination.getCountry() : "",
                    vacination.getIsoCode() != null ? vacination.getIsoCode() : "",
                    vacination.getDate() != null ? vacination.getDate() : LocalDate.now(),
                    vacination.getTotalVaccinations() != null ? vacination.getTotalVaccinations() : 0L,
                    vacination.getPeopleVaccinated() != null ? vacination.getPeopleVaccinated() : 0L,
                    vacination.getPeopleFullyVaccinated() != null ? vacination.getPeopleFullyVaccinated() : 0L,
                    vacination.getDailyVaccinationsRaw() != null ? vacination.getDailyVaccinationsRaw() : 0.0,
                    vacination.getDailyVaccinations() != null ? vacination.getDailyVaccinations() : 0.0,
                    vacination.getTotalVaccinationsPerHundred() != null ? vacination.getTotalVaccinationsPerHundred()
                            : 0.0,
                    vacination.getPeopleVaccinatedPerHundred() != null ? vacination.getPeopleVaccinatedPerHundred()
                            : 0.0,
                    vacination.getPeopleFullyVaccinatedPerHundred() != null
                            ? vacination.getPeopleFullyVaccinatedPerHundred()
                            : 0.0,
                    vacination.getDailyVaccinationsPerMillion() != null ? vacination.getDailyVaccinationsPerMillion()
                            : 0.0,
                    vacination.getVaccines() != null ? vacination.getVaccines() : "",
                    vacination.getSourceName() != null ? vacination.getSourceName() : "",
                    vacination.getSourceWebsite() != null ? vacination.getSourceWebsite() : "");
        }
    }

    @Override
    public List<VacinationSummaryDto> getDateTotalVacination() {
        String sql = "SELECT date, total_vaccinations FROM vaccinations";
        return jdbcTemplate.query(sql, new VacinationSummaryRowMapper());
    }

    private static class VacinationSummaryRowMapper implements RowMapper<VacinationSummaryDto> {
        @Override
        public VacinationSummaryDto mapRow(ResultSet rs, int rowNum) throws SQLException {
            VacinationSummaryDto dto = new VacinationSummaryDto();
            dto.setDate(rs.getDate("date").toLocalDate());
            dto.setTotalVaccinations(rs.getDouble("total_vaccinations"));
            return dto;
        }
    }

    @Override
    public List<VacinationDateDaily> getDateDailyVacination() {
        String sql = "SELECT date, daily_vaccinations FROM vaccinations order by date ASC";
        return jdbcTemplate.query(sql, new VacinationDateDailyRowMapper());
    }

    private static class VacinationDateDailyRowMapper implements RowMapper<VacinationDateDaily> {
        @Override
        public VacinationDateDaily mapRow(ResultSet rs, int rowNum) throws SQLException {
            VacinationDateDaily dto = new VacinationDateDaily();
            dto.setDate(rs.getDate("date").toLocalDate());
            dto.setDailyVaccinations(rs.getDouble("daily_vaccinations"));
            return dto;
        }
    }

    @Override
    public List<VacinationMonthSummary> getMonthlyVacinationSummary() {
        String sql = "SELECT " +
                "DATE_TRUNC('month', date) AS month_start, " +
                "TO_CHAR(DATE_TRUNC('month', date), 'Mon/YYYY') AS month_year, " +
                "SUM(total_vaccinations) AS total_vaccinations " +
                "FROM vaccinations " +
                "GROUP BY DATE_TRUNC('month', date) " +
                "ORDER BY month_start";

        return jdbcTemplate.query(sql, new MonthlyVacinationSummaryRowMapper());
    }

    private static class MonthlyVacinationSummaryRowMapper implements RowMapper<VacinationMonthSummary> {
        @Override
        public VacinationMonthSummary mapRow(ResultSet rs, int rowNum) throws SQLException {
            VacinationMonthSummary summary = new VacinationMonthSummary();
            summary.setMonthStart(rs.getDate("month_start").toLocalDate());
            summary.setYearMonth(rs.getString("month_year"));
            summary.setTotalVaccinations(rs.getDouble("total_vaccinations"));
            return summary;
        }
    }

    @Override
    public List<VacinationCountryTotal> getCountryTotalVacinationSummary() {
        String sql = "SELECT " +
                "country, " +
                "SUM(total_vaccinations) AS total_vaccinations " +
                "FROM vaccinations " +
                "GROUP BY country " +
                "ORDER BY total_vaccinations DESC";

        return jdbcTemplate.query(sql, new YearCountryVacinationSummaryRowMapper());
    }

    private static class YearCountryVacinationSummaryRowMapper implements RowMapper<VacinationCountryTotal> {
        @Override
        public VacinationCountryTotal mapRow(ResultSet rs, int rowNum) throws SQLException {
            VacinationCountryTotal summary = new VacinationCountryTotal();
            summary.setCountry(rs.getString("country"));
            summary.setTotalVaccinations(rs.getDouble("total_vaccinations"));
            return summary;
        }
    }

}
