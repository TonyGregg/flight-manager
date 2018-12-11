package com.genil.learning.flightmanager.repository;

import com.genil.learning.flightmanager.entity.City;
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
 * Created by Antony Genil Gregory on 12/11/2018 7:08 AM
 * For project : flight-manager
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CityRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CityRepository cityRepository;

    @Test
    public void findAll() {
        List<City> cities = cityRepository.findAll();
        logger.info("{} ",cities);
        assertTrue(cities.size()>0);
    }
}