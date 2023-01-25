package com.careerdevs.CovidData.repositories;

import com.careerdevs.CovidData.models.CovidTrackingData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CovidTrackingDataRepo  extends JpaRepository<CovidTrackingData,Long> {
}
