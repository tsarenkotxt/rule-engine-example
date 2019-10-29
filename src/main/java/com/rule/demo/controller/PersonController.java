package com.rule.demo.controller;

import com.rule.demo.engine.PersonRuleEngine;
import com.rule.demo.model.Person;
import com.rule.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.jeasy.rules.api.Rule;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;
    private final PersonRuleEngine personRuleEngine;

    @GetMapping("/{id}")
    public Person get(@PathVariable("id") Long id) {
        return personService.findById(id);
    }

    @GetMapping
    public Iterable<Person> getAll() {
        return personService.findAll();
    }

    @PostMapping
    public Map<Rule, Boolean> process(@RequestBody Person person) {
        return personRuleEngine.process(person);
    }

}
