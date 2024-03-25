package com.novemberecho.SearchModule.Repository;

import com.novemberecho.SearchModule.Entity.FlightData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightDataRepository extends JpaRepository<FlightData, Integer> {
}
