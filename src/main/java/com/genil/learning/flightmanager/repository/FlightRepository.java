package com.genil.learning.flightmanager.repository;

import com.genil.learning.flightmanager.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Antony Genil Gregory on 12/11/2018 6:39 AM
 * For project : flight-manager
 **/
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByFromCity(String fromCity);
    List<Flight> findByToCity(String toCity);
}
