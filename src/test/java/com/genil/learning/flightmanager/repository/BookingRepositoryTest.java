package com.genil.learning.flightmanager.repository;

import com.genil.learning.flightmanager.entity.Booking;
import com.genil.learning.flightmanager.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Antony Genil Gregory on 12/11/2018 7:16 AM
 * For project : flight-manager
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UserRepository userRepository;


    @Test
    public void findByUser() {
        List<Booking> bookings = bookingRepository.findByUser(1L);
        logger.info("{}",bookings);
        assertTrue(bookings.size()>0);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void save() {
        User user = userRepository.getOne(1L);
        Booking booking = new Booking();
        booking.setUser(user);

        booking.setAirline("United");
        booking.setTotalCost(560.25);
        booking.setDepartureDate(LocalDate.of(2018,12,24));
        booking.setArrivalTime("22:00 Hrs");
        booking.setNumOfPassengers(5);

        booking = bookingRepository.save(booking);

        logger.info("Newly created user booking {} ",booking);
        assertNotNull(booking);


    }

    @Test
    @Transactional
    @Rollback(false)
    public void deleteById() {
        Long bookingId = 25l;
        bookingRepository.deleteById(bookingId);
        assertTrue(true);

    }
}