package com.fickshare.repo;

import com.fickshare.domain.Reservation;
import com.fickshare.domain.ReservationItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationItemsRepo extends JpaRepository<ReservationItems,Long>
{

}
