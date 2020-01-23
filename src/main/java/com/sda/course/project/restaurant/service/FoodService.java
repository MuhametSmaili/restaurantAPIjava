package com.sda.course.project.restaurant.service;

import com.sda.course.project.restaurant.entity.Food;
import com.sda.course.project.restaurant.repository.FoodRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public List<Food> findAll(){return foodRepository.findAll();}
    public Food createFood(@Valid @NotNull Food food){ return foodRepository.save(food);}
}
