package com.sda.course.project.restaurant.repository;

import com.sda.course.project.restaurant.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Integer> {
}
