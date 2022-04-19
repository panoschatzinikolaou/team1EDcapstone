package com.edteam1.smdb.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PERSON")
@SequenceGenerator(name = "idGenerator", sequenceName = "PERSON_SEQ", allocationSize = 1)
public class Person extends BaseModel{

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private String age;

    @NotNull
    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Occupation occupation;

    @ManyToMany(cascade = { CascadeType.ALL }, mappedBy = "persons")
    Set<Production> productions = new HashSet<>();
}