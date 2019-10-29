package com.rule.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "composite_rule")
public class CompositeRule {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String name;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<CustomRule> rules;

}
