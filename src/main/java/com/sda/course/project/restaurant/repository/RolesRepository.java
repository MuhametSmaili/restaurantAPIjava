package com.sda.course.project.restaurant.repository;

import com.sda.course.project.restaurant.entity.Persons;
import com.sda.course.project.restaurant.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles,Integer> {
}
