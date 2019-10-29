package com.rule.demo.controller;

import com.rule.demo.config.CustomRuleAction;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rules/actions")
@RequiredArgsConstructor
public class RuleActionController {

    private final List<CustomRuleAction> ruleActions;

    @GetMapping
    public List<String> getAll() {
        return ruleActions.stream()
                .map(CustomRuleAction::getAction)
                .collect(Collectors.toList());
    }

}
