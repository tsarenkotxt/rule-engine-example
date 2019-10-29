package com.rule.demo.engine;

import com.rule.demo.model.Person;
import com.rule.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class PersonRuleEngine {

    private final Rules rules;
    private final RulesEngine rulesEngine;
    private final PersonService personService;

    public Map<Rule, Boolean> process(Person person) {
        Facts facts = new Facts();
        facts.put("person", person);
        facts.put("personService", personService);

        rulesEngine.fire(rules, facts);
        return rulesEngine.check(rules, facts);
    }

}
