package com.genil.learning.flightmanager.repository;

import com.genil.learning.flightmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Antony Genil Gregory on 12/11/2018 6:35 AM
 * For project : flight-manager
 **/
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User save(User user);
}
