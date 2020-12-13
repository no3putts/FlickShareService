package com.fickshare.repo;

import com.fickshare.domain.Director;
import com.fickshare.domain.Star;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarRepo extends JpaRepository<Star,Long>
{
}