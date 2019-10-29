package com.rule.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id",
            referencedColumnName = "id")
    private Item item;

}
