package com.ashu.practice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final String USERS_SEQUENCE = "USERS_ID_SEQUENCE";

    @Serial
    private static final long serialVersionUID = -7154849399198245482L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = USERS_SEQUENCE)
    @SequenceGenerator(name = USERS_SEQUENCE, sequenceName = USERS_SEQUENCE, allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DATETIME", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime regTime;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "USER_ID")
    private List<Address> addresses = new ArrayList<>();

}
