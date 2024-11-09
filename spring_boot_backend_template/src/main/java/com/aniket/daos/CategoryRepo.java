package com.aniket.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aniket.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
