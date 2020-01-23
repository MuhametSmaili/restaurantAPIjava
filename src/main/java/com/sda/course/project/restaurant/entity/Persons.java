package com.sda.course.project.restaurant.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.Order;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persons {
    @Id
    @Column(name = "personId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private Date birthday;
    @Column
    private String address;
//    @OneToMany(mappedBy = "persons")
//    private List<OrderFood> orders;
    @ManyToMany
    private List<Roles> role;
    @Column
    private String email;
}