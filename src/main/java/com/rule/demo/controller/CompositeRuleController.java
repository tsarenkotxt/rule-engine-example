package com.rule.demo.controller;

import com.rule.demo.model.CompositeRule;
import com.rule.demo.service.CompositeRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rules/composite")
@RequiredArgsConstructor
public class CompositeRuleController {

    private final CompositeRuleService compositeRuleService;

    @GetMapping("/{id}")
    public CompositeRule get(@PathVariable("id") Long id) {
        return compositeRuleService.findById(id);
    }

    @GetMapping
    public Iterable<CompositeRule> getAll() {
        return compositeRuleService.findAll();
    }

    @PostMapping
    public CompositeRule save(@RequestBody CompositeRule compositeRule) {
        return compositeRuleService.save(compositeRule);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        compositeRuleService.delete(id);
    }

}
