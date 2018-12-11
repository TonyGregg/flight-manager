package com.genil.learning.flightmanager.repository;

import com.genil.learning.flightmanager.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Antony Genil Gregory on 12/11/2018 7:02 AM
 * For project : flight-manager
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserRepository userRepository;

    @Test
    public void findByEmail() {
        User user = userRepository.findByEmail("test1@gmail.com");
        logger.info("{} ",user);
        assertTrue(user.getId().intValue()==1);
    }

    @Test
    @Rollback(false)
    public void save() {
        User user = new User();
        user.setEmail("test4@test.com");
        user.setPassword("test4");

        user = userRepository.save(user);
        assertNotNull(user);

    }
}