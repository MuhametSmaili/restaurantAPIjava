package com.sda.course.project.restaurant.repository;

import com.sda.course.project.restaurant.entity.OrderFood;
import com.sun.istack.NotNull;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import java.util.List;

@Repository
public interface OrderFoodRepository extends JpaRepository<OrderFood,Integer> {

    List<OrderFood> findOrderFoodByPersonsPersonId(@Valid @NotNull int persons);

    @Query(value = "select u from OrderFood u order by u.totalPrice desc")
    List<OrderFood> findAllOrderSorted();

    @Query(value = "select order_id,order_date,sum(total_price) as total_price,type_of_payment,person_id from order_food group by person_id order by SUM(total_price) desc;",nativeQuery = true)
    List<OrderFood> findOrderFoodByCostumerSortedByTotalPrice();
}
