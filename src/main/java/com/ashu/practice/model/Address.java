package com.ashu.practice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "ADDRESSES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {

    private static final String ADDRESSES_SEQUENCE = "ADDRESSES_ID_SEQUENCE";

    @Serial
    private static final long serialVersionUID = 581392274560519988L;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ADDRESSES_SEQUENCE)
    @SequenceGenerator(name = ADDRESSES_SEQUENCE, sequenceName = ADDRESSES_SEQUENCE, allocationSize = 1)
    private Long id;

    private String addr1;

    private String addr2;

    private String city;

    private String country;

    private int zip;
}
