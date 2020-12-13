package com.fickshare.repo;

import com.fickshare.domain.Star;
import com.fickshare.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long>
{
}