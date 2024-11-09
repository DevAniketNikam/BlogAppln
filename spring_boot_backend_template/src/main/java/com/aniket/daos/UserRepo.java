package com.aniket.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aniket.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
