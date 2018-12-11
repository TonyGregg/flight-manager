package com.genil.learning.flightmanager.entity;



import javax.persistence.*;
import java.time.LocalDate;


/**
 * Created by Antony Genil Gregory on 12/11/2018 6:03 AM
 * For project : flight-manager
 **/
@Entity (name = "booking")
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String airline;

    @Column(name = "num_passengers")
    private Integer numOfPassengers;
    @Column(name = "dep_date")
    private LocalDate departureDate;
    @Column(name = "arrival_time")
    private String arrivalTime;
    @Column(name = "total_cost")
    private Double totalCost;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @ManyToOne
    private User user;

    public Long getId() {
        return id;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Integer getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(Integer numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", airline='" + airline + '\'' +
                ", numOfPassengers=" + numOfPassengers +
                ", departureDate=" + departureDate +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", totalCost=" + totalCost +
                ", user=" + user +
                '}';
    }
}
