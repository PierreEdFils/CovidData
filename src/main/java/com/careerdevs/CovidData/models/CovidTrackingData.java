package com.careerdevs.CovidData.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CovidTrackingData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long id;

    private boolean success;
    public CovidTrackingData(String countryName, boolean success) {
        this.data  = countryName;
        this.success = success;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isSuccess() {
        return success;
    }
    private String data;

    public String getData() {
        return data;
    }
    public CovidTrackingData() {
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setData(String data) {
        this.data = data;
    }
}
