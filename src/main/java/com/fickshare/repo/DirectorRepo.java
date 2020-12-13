package com.fickshare.repo;

import com.fickshare.domain.Director;
import com.fickshare.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DirectorRepo extends JpaRepository<Director,Long>
{
}