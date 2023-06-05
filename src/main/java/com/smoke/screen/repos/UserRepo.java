package com.smoke.screen.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smoke.screen.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
