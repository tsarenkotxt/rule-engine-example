package com.rule.demo.service;

import com.rule.demo.converter.RuleConverter;
import com.rule.demo.model.CompositeRule;
import com.rule.demo.repository.CompositeRuleRepository;
import lombok.RequiredArgsConstructor;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.support.UnitRuleGroup;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompositeRuleService {

    private final Rules rules;
    private final RuleConverter ruleConverter;
    private final CompositeRuleRepository compositeRuleRepository;

    public Iterable<CompositeRule> findAll() {
        return compositeRuleRepository.findAll();
    }

    public CompositeRule findById(Long id) {
        return compositeRuleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Rule not found, id: " + id));
    }

    public CompositeRule save(CompositeRule compositeRule) {
        UnitRuleGroup ruleGroup = new UnitRuleGroup(compositeRule.getName());
        compositeRule.getRules().stream()
                .map(ruleConverter::convertToRule)
                .forEach(ruleGroup::addRule);

        rules.register(ruleGroup);
        try {
            return compositeRuleRepository.save(compositeRule);
        } catch (Exception e) {
            throw new IllegalArgumentException("Names should be unique, id: " + compositeRule);
        }
    }

    public void delete(Long id) {
        compositeRuleRepository.deleteById(id);
    }

}
