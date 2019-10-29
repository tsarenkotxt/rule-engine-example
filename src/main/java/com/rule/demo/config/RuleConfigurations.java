package com.rule.demo.config;

import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RuleConfigurations {

    @Bean
    public Rules rules() {
        return new Rules();
    }

    @Bean
    public RulesEngine rulesEngine() {
        return new DefaultRulesEngine();
    }

    @Bean
    public List<CustomRuleAction> customRuleAction() {
        return List.of(
                new CustomRuleAction("savePerson",
                        "personService.save(person);"),
                new CustomRuleAction("sendPersonToVendorOne",
                        "personService.sendToVendorOne(person);"),
                new CustomRuleAction("sendPersonToVendorTwo",
                        "personService.sendToVendorTwo(person);"),
                new CustomRuleAction("sendPersonToVendorThree",
                        "personService.sendToVendorThree(person);"));
    }

}
