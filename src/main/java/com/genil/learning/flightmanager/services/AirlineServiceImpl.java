package com.genil.learning.flightmanager.services;

import com.genil.learning.flightmanager.config.FlightConfig;
import com.genil.learning.flightmanager.entity.User;
import com.genil.learning.flightmanager.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Antony Genil Gregory on 12/11/2018 6:54 AM
 * For project : flight-manager
 **/
@Component
public class AirlineServiceImpl implements AirlineService{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FlightConfig flightConfig;

    @Autowired
    UserRepository userRepository;

    @Override
    public User isValidUser(String email) {
        /**
         * Check from back-end DB if the user name is there or not
         */
        User user = userRepository.findByEmail(email);
        if(user != null) {
            logger.info("User found {} ",user);
            return user;
        }

        return null;
    }

    @Override
    public boolean isUserPasswordValid(User user, String password) {
        return password.equals(user.getPassword())?true:false;
    }
}
