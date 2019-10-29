package com.rule.demo.service;

import com.rule.demo.config.RuleConfigurations;
import com.rule.demo.model.Person;
import com.rule.demo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not found, id: " + id));
    }

    /**
     * The action method for action 'savePerson'
     *
     * @see RuleConfigurations#customRuleAction()
     */
    public void save(Person rule) {
        personRepository.save(rule);
    }

    /**
     * The action method for action 'sendPersonToVendorOne'
     *
     * @see RuleConfigurations#customRuleAction()
     */
    public void sendToVendorOne(Person person) {
        System.out.println("Send person to vendor 'one': " + person);
    }

    /**
     * The action method for action 'sendPersonToVendorTwo'
     *
     * @see RuleConfigurations#customRuleAction()
     */
    public void sendToVendorTwo(Person person) {
        System.out.println("Send person to vendor 'two': " + person);
    }

    /**
     * The action method for action 'sendPersonToVendorThree'
     *
     * @see RuleConfigurations#customRuleAction()
     */
    public void sendToVendorThree(Person person) {
        System.out.println("Send person to vendor 'three': " + person);
    }

}
