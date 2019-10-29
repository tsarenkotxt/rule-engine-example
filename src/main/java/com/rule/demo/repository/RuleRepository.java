package com.rule.demo.repository;

import com.rule.demo.model.CustomRule;
import org.springframework.data.repository.CrudRepository;

public interface RuleRepository extends CrudRepository<CustomRule, Long> {

}
