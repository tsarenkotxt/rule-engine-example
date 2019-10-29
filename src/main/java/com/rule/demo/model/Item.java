package com.rule.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "item")
@EqualsAndHashCode(exclude = "person")
public class Item {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int count;

    @OneToOne(mappedBy = "item")
    @JsonIgnore
    private Person person;

}
