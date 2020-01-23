package com.sda.course.project.restaurant.repository;

import com.sda.course.project.restaurant.entity.Food;
import com.sda.course.project.restaurant.entity.Persons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Integer> {
}
