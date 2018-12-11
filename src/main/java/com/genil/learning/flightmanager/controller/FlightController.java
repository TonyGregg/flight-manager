package com.genil.learning.flightmanager.controller;

import com.genil.learning.flightmanager.entity.Booking;
import com.genil.learning.flightmanager.entity.User;
import com.genil.learning.flightmanager.repository.BookingRepository;
import com.genil.learning.flightmanager.repository.CityRepository;
import com.genil.learning.flightmanager.repository.FlightRepository;
import com.genil.learning.flightmanager.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Antony Genil Gregory on 12/11/2018 11:17 AM
 * For project : flight-manager
 **/

@RestController
@RequestMapping("/api/v1/atbs")
public class FlightController {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Get the User for a given id
     * @param id
     * @return User object
     *
     * Post man URL sample to test http://localhost:8090/api/v1/atbs/user/2
     *
     */

    @RequestMapping("/user/{id}")
    public User getUserById(@PathVariable(value = "id")Long id) {
        logger.info("Id passed {} ",id);
        User user = userRepository.getOne(id);
        logger.info("User retrieved {} ", user);
        return user;
    }


    /**
     *
     * @param email
     * @return User object matching with email
     *
     */
    @RequestMapping("user/email/{email}")
    public User getUserByEmail(@PathVariable(value = "email")String email) {
        logger.info("Email passed {} ",email);
        User user = userRepository.findByEmail(email);
        logger.info("User retrieved {} ", user);
        return user;
    }

    /**
     * Method to save the user
     * http://localhost:8090/api/v1/atbs/user
     *
     * Sample
     * {
     *     "email": "test11@test.com",
     *     "password": "test10"
     * }
     *
     */
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody @Valid User user) { return userRepository.save(user);}

    /**
     * Get all the bookings made by a particular user
     * http://localhost:8090/api/v1/atbs/bookings/user/3
     */
    @RequestMapping("bookings/user/{id}")
    public List<Booking> getFlightBookingsByUser(@PathVariable(value = "id") Long id) {
        logger.info("User id passed {} ", id);
        return bookingRepository.findByUser(id);
    }

    /**
     * Save User booking
     *
     * http://localhost:8090/api/v1/atbs/book
     * Sample
     *  {
     *
     *         "airline": "United",
     *         "numOfPassengers": 20,
     *         "departureDate": "2019-02-27",
     *         "arrivalTime": "19:30 Hrs",
     *         "totalCost": 4500.50,
     *         "userId": 3,
     *         "user": {
     *             "id": 2,
     *             "email": "test2@gmail.com",
     *             "password": "test2"
     *         }
     *     }
     *
     */

    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public Booking saveBooking(@RequestBody @Valid Booking booking) {
        return bookingRepository.save(booking);
    }

    /**
     * Delete user made booking
     * Sample
     * http://localhost:8090/api/v1/atbs/bookings/remove/27
     */
    @RequestMapping("/bookings/remove/{id}")
    public String removeUserBooking(@PathVariable(value = "id") Long bookingId) {
        logger.info("Booking id to be removed {}",bookingId);
        Booking booking = bookingRepository.getOne(bookingId);
        logger.info("Booking exists ... {}",booking);
        //Remove the booking. .
        bookingRepository.deleteById(bookingId);
        logger.info("Booking removed.. {} ",bookingId);
        return "Booking removed "+bookingId;
    }


}
