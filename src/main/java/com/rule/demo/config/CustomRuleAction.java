package com.rule.demo.config;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomRuleAction {

    private String action;
    private String actionMethod;

}
