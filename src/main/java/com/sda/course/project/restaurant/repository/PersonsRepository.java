package com.sda.course.project.restaurant.repository;

import com.sda.course.project.restaurant.entity.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PersonsRepository extends JpaRepository<Persons, Integer>, PagingAndSortingRepository<Persons,Integer> {

    List<Persons> findByEmail(String email);
}