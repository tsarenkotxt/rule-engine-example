package com.rule.demo.service;

import com.rule.demo.converter.RuleConverter;
import com.rule.demo.model.CustomRule;
import com.rule.demo.repository.RuleRepository;
import lombok.RequiredArgsConstructor;
import org.jeasy.rules.api.Rules;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RuleService {

    private final Rules rules;
    private final RuleConverter ruleConverter;
    private final RuleRepository ruleRepository;

    public Iterable<CustomRule> findAll() {
        return ruleRepository.findAll();
    }

    public CustomRule findById(Long id) {
        return ruleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Rule not found, id: " + id));
    }

    public CustomRule save(CustomRule rule) {
        rules.register(ruleConverter.convertToRule(rule));
        try {
            return ruleRepository.save(rule);
        } catch (Exception e) {
            throw new IllegalArgumentException("Name should be unique, id: " + rule);
        }
    }

    public void delete(Long id) {
        ruleRepository.deleteById(id);
    }

}
