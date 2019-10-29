package com.rule.demo.converter;

import com.rule.demo.config.CustomRuleAction;
import com.rule.demo.model.CustomRule;
import lombok.RequiredArgsConstructor;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.mvel.MVELRule;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RuleConverter {

    private final List<CustomRuleAction> ruleActions;

    public Rule convertToRule(CustomRule customRule) {
        return new MVELRule()
                .name(customRule.getName())
                .description(customRule.getDescription())
                .priority(customRule.getPriority())
                .when(customRule.getCondition())
                .then(defineActionMethod(customRule.getAction()));
    }

    private String defineActionMethod(String action) {
        return ruleActions.stream()
                .filter(ruleAction -> ruleAction.getAction().equals(action))
                .map(CustomRuleAction::getActionMethod)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Undefined action: " + action));
    }

}
