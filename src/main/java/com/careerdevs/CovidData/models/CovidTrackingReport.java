package com.careerdevs.CovidData.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CovidTrackingReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long id;

    private String CountryName;

    private String regionName;

    private int caseCount;

    private int recoveredCount ;

    private int deceasedCount ;

    private  String regionFlagUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CovidTrackingReport() {
    }

    public CovidTrackingReport(String countryName, String regionName, int caseCount, int recoveredCount, int deceasedCount, String regionFlagUrl) {
        CountryName = countryName;
        this.regionName = regionName;
        this.caseCount = caseCount;
        this.recoveredCount = recoveredCount;
        this.deceasedCount = deceasedCount;
        this.regionFlagUrl = regionFlagUrl;
    }

    public String getCountryName() {
        return CountryName;
    }

    public String getRegionName() {
        return regionName;
    }

    public int getCaseCount() {
        return caseCount;
    }

    public int getRecoveredCount() {
        return recoveredCount;
    }

    public int getDeceasedCount() {
        return deceasedCount;
    }

    public String getRegionFlagUrl() {
        return regionFlagUrl;
    }
}
