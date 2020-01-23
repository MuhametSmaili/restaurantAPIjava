package com.sda.course.project.restaurant.controllers;

import com.querydsl.core.Tuple;
import com.sda.course.project.restaurant.entity.OrderFood;
import com.sda.course.project.restaurant.service.OrderFoodService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderFoodController {

    @Autowired
    private OrderFoodService orderFoodService;

    @GetMapping
    public @ResponseBody
    List<OrderFood> findAll(){
        return orderFoodService.findAll();
    }

    @GetMapping("/all")
    public @ResponseBody
    List<OrderFood> findAllOrderSorted(){
        return orderFoodService.findAllOrderSorted();
    }

    @PostMapping("/")
    public void save(@RequestBody @NotNull @Valid OrderFood orderFood){
        orderFoodService.save(orderFood);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    List<OrderFood> findOrdersByPersonId(@NotNull @Valid @PathVariable int id){ return orderFoodService.findOrdersByPersonId(id);}

    @GetMapping("/top")
    public @ResponseBody
    List<OrderFood> findOrdersByPersonsTotalPrice(){return orderFoodService.findOrdersByTotalPrice();}

    @GetMapping("/top2")
    public @ResponseBody
    List<OrderFood> test(){return orderFoodService.findOrderFoodSortedByBestCostumer();}
}