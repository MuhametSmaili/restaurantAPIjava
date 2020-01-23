package com.sda.course.project.restaurant.controllers;

import com.sda.course.project.restaurant.entity.Food;
import com.sda.course.project.restaurant.service.FoodService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/food")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping(path = "/all")
    public @ResponseBody List<Food> findAllFood(){
        return foodService.findAll();
    }

    @PostMapping
    public Food createFood(@Valid @NotNull @RequestBody Food food){
        return foodService.createFood(food);
    }

}
