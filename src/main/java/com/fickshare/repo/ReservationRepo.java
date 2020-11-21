package com.fickshare.repo;

import com.fickshare.domain.Movie;
import com.fickshare.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepo extends JpaRepository<Reservation,String>
{
}
