package com.sda.course.project.restaurant.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//TODO: remove unused imports and code also can add some validation on fields
public class Food {
    @Id
    @Column(name = "foodId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foodId;
    @Column
    private String name;
    @Column
    private double price;
//    @OneToMany(mappedBy = "orderFood")
//    private List<OrderDetails> orderDetails;
}
