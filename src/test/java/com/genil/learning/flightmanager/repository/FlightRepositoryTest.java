package com.genil.learning.flightmanager.repository;

import com.genil.learning.flightmanager.entity.Flight;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Antony Genil Gregory on 12/11/2018 7:11 AM
 * For project : flight-manager
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    FlightRepository flightRepository;

    @Test
    public void findByFromCity() {
        List<Flight> flights;
        String fromCity = "Boston";

        flights = flightRepository.findByFromCity(fromCity);
        logger.info("{}",flights);

        assertTrue(flights.size()>1);

    }

    @Test
    public void findByToCity() {
        List<Flight> flights;
        String toCity = "Atlanta";

        flights = flightRepository.findByToCity(toCity);
        logger.info("{}",flights);

        assertTrue(flights.size()>1);
    }
}