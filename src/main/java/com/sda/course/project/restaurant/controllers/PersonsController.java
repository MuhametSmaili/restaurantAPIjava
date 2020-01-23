package com.sda.course.project.restaurant.controllers;

import com.sda.course.project.restaurant.entity.Persons;
import com.sda.course.project.restaurant.service.PersonsService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonsController {

    @Autowired
    private PersonsService personsService;

    @GetMapping
    public @ResponseBody
    List<Persons> findAll(){

        Pageable firstPageWithTwoElements = PageRequest.of(0, 2);

//        return personsService.findAll(firstPageWithTwoElements);
        return personsService.findAll(firstPageWithTwoElements);
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    Optional<Persons> findById(@Valid @NotNull @PathVariable Integer id){
        return personsService.findById(id);
    }

    @PostMapping
    public void save(@Valid @NotNull @RequestBody Optional<Persons> persons){ personsService.save(persons);}

    @PostMapping("/")
    public void saveAll(@NotNull @Valid @RequestBody ArrayList<Persons> persons){ personsService.saveAll(persons);}

    @PatchMapping("/update/{id}")
    public void update(@Valid @NotNull @PathVariable(value = "id") int id,@Valid @NotNull @RequestBody Optional<Persons> persons) {
        Optional<Persons> persons1 = personsService.findById(id);

        if (persons.orElseThrow().getName()!=null){
            persons1.orElseThrow().setName(persons.orElseThrow().getName());
        }
        if (persons.orElseThrow().getSurname()!=null){
            persons1.orElseThrow().setSurname(persons.orElseThrow().getSurname());
        }
        if (persons.orElseThrow().getAddress()!=null){
            persons1.orElseThrow().setAddress(persons.orElseThrow().getAddress());
        }
        if (persons.orElseThrow().getEmail()!=null){
            persons1.orElseThrow().setEmail(persons.orElseThrow().getEmail());
        }
        personsService.save(persons1);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@Valid @NotNull @PathVariable int id){ personsService.deleteById(id);}

    @GetMapping(path="/email/{email}")
    public @ResponseBody List<Persons> findByEmail(@Valid @NotNull @PathVariable(value = "email") String email){ return personsService.findByEmail(email);}
}