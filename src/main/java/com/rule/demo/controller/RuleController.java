package com.rule.demo.controller;

import com.rule.demo.model.CustomRule;
import com.rule.demo.service.RuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rules")
@RequiredArgsConstructor
public class RuleController {

    private final RuleService ruleService;

    @GetMapping("/{id}")
    public CustomRule get(@PathVariable("id") Long id) {
        return ruleService.findById(id);
    }

    @GetMapping
    public Iterable<CustomRule> getAll() {
        return ruleService.findAll();
    }

    @PostMapping
    public CustomRule save(@RequestBody CustomRule customRule) {
        return ruleService.save(customRule);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        ruleService.delete(id);
    }

}
