package com.genil.learning.flightmanager.services;

import com.genil.learning.flightmanager.entity.User;
import org.springframework.stereotype.Component;

/**
 * Created by Antony Genil Gregory on 12/11/2018 6:53 AM
 * For project : flight-manager
 **/
@Component
public interface AirlineService {
    public User isValidUser(String email);
    public boolean isUserPasswordValid(User user, String password);


}
