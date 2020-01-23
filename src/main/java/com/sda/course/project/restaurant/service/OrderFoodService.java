package com.sda.course.project.restaurant.service;

import com.querydsl.core.Tuple;
//import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQuery;
import com.sda.course.project.restaurant.entity.OrderFood;
import com.sda.course.project.restaurant.entity.QOrderFood;
import com.sda.course.project.restaurant.repository.OrderFoodRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.util.List;

@Service
public class OrderFoodService {

    @Autowired
    private OrderFoodRepository orderFoodRepository;
    @Autowired
    EntityManager entityManager;


    public List<OrderFood> findAll() { return orderFoodRepository.findAll(); }
    public List<OrderFood> findAllOrderSorted(){return orderFoodRepository.findAllOrderSorted();}
    public void save(@NotNull @Valid OrderFood orderFood){ orderFoodRepository.save(orderFood); }
    public List<OrderFood> findOrdersByPersonId(@NotNull @Valid int id){ return orderFoodRepository.findOrderFoodByPersonsPersonId(id);}
    public List<OrderFood> findOrderFoodSortedByBestCostumer(){
        QOrderFood orderFood = QOrderFood.orderFood;
        JPAQuery<?> query = new JPAQuery<Void>(entityManager);
        return  query.from(orderFood).select(orderFood).groupBy(orderFood.persons.personId).orderBy(orderFood.totalPrice.sum().desc()).fetch();
    }

    public List<OrderFood> findOrdersByTotalPrice(){
        return orderFoodRepository.findOrderFoodByCostumerSortedByTotalPrice();
    }
}
