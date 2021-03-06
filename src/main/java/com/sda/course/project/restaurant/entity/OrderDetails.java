package com.sda.course.project.restaurant.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {
    @Id
    @Column(name = "orderDetailsId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @Column
    private int quantity;
    @Column
    private double priceUnit;
    @ManyToOne
    @JoinColumn(name = "food")
    private Food food;
    @ManyToOne
    @JoinColumn
    private OrderFood orderFood;
}
