package com.sda.course.project.restaurant.service;

import com.sda.course.project.restaurant.entity.Persons;
import com.sda.course.project.restaurant.repository.PersonsRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class PersonsService {

    @Autowired
    private PersonsRepository personsRepository;

    public List<Persons> findAll(Pageable pageable){

        Page<Persons> persons= personsRepository.findAll(pageable);

//return persons;
        return personsRepository.findAll();
    }
    public void save(@Valid @NotNull Optional<Persons> persons){personsRepository.save(persons.orElseThrow());}
    public Optional<Persons> findById(@Valid @NotNull int id){return personsRepository.findById(id);}
    public void deleteById(@Valid @NotNull int id){personsRepository.deleteById(id);}
    public void saveAll(@Valid @NotNull List<Persons> persons) {
        personsRepository.saveAll(persons);
    }
    public List<Persons> findByEmail(@Valid @NotNull String email) {
        return personsRepository.findByEmail(email);
    }
}