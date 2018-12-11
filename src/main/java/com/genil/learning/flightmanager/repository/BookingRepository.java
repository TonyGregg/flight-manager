package com.genil.learning.flightmanager.repository;

import com.genil.learning.flightmanager.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Antony Genil Gregory on 12/11/2018 6:42 AM
 * For project : flight-manager
 **/
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("select b from booking b where b.userId=?1")
    List<Booking>findByUser(Long userId);
    Booking save(Booking booking);

    @Modifying
    @Transactional
    @Query("delete from booking b where b.id =?1")
    void deleteById(Long id);

}
