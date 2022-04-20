package com.edteam1.smdb.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PRODUCTION")
@SequenceGenerator(name = "idGenerator", sequenceName = "PRODUCTION_SEQ", allocationSize = 1)
public class Production extends BaseModel{

    @NotNull
    @Column(nullable = false)
    private String title;

    @NotNull
    @Column(nullable = false)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date releasedYear;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private ProductionType type;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "Person_Production",
            joinColumns = @JoinColumn(name = "production_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    Set<Person> persons = new HashSet<>();
}
