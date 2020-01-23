package com.sda.course.project.restaurant.entity;

import com.querydsl.core.types.dsl.DatePath;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderFood {

    @Id
    @Column(name = "orderId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @Column
    private Date orderDate;
    @Column
    private double totalPrice;
    @Column
    private String typeOfPayment;
    @ManyToOne
    @JoinColumn(name = "personId")
    private Persons persons;
    @OneToMany(mappedBy = "food")
    private List<OrderDetails> orderDetails;
}
