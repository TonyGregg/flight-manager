package com.genil.learning.flightmanager.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Antony Genil Gregory on 12/11/2018 6:11 AM
 * For project : flight-manager
 **/
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class FlightConfig {

    private String userNotRegisteredMsg;
    private String adminErrorMsg;
    private String userPasswordOrIdIncorrectMsg;


    public String getUserNotRegisteredMsg() {
        return userNotRegisteredMsg;
    }

    public void setUserNotRegisteredMsg(String userNotRegisteredMsg) {
        this.userNotRegisteredMsg = userNotRegisteredMsg;
    }

    public String getAdminErrorMsg() {
        return adminErrorMsg;
    }

    public void setAdminErrorMsg(String adminErrorMsg) {
        this.adminErrorMsg = adminErrorMsg;
    }

    public String getUserPasswordOrIdIncorrectMsg() {
        return userPasswordOrIdIncorrectMsg;
    }

    public void setUserPasswordOrIdIncorrectMsg(String userPasswordOrIdIncorrectMsg) {
        this.userPasswordOrIdIncorrectMsg = userPasswordOrIdIncorrectMsg;
    }
}
