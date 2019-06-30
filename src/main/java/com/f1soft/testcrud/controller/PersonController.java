package com.f1soft.testcrud.controller;


import com.f1soft.testcrud.entity.Person;
import com.f1soft.testcrud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;


    @PostMapping
    public Person save(@RequestBody Person person) {
        return personRepository.save(person);
    }

}
