package com.sda.course.project.restaurant.service;

import com.sda.course.project.restaurant.entity.Persons;
import com.sda.course.project.restaurant.entity.Roles;
import com.sda.course.project.restaurant.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    public List<Roles> getAllRoles() {return rolesRepository.findAll();}
    public void removeRoleById(int id){ rolesRepository.deleteById(id);}
    public void addPersonsRole(Roles roles){rolesRepository.save(roles);}
    public void updateRole(Roles roles){rolesRepository.save(roles);}

}
