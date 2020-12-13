package com.fickshare.repo;

import com.fickshare.domain.Director;
import com.fickshare.domain.MovieStar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieStarRepo extends JpaRepository<MovieStar,Long>
{
}