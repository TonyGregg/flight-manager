package com.genil.learning.flightmanager.repository;

import com.genil.learning.flightmanager.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Antony Genil Gregory on 12/11/2018 6:38 AM
 * For project : flight-manager
 **/
public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findAll();
}
