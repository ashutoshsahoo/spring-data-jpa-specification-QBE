package com.ashu.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ADDRESSES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {

    private static final long serialVersionUID = 581392274560519988L;

    private static final String ADDRESSES_SEQUENCE = "SEQ_ADDRESSES";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = ADDRESSES_SEQUENCE)
    @SequenceGenerator(name = ADDRESSES_SEQUENCE, sequenceName = ADDRESSES_SEQUENCE, allocationSize = 1)
    private Long id;

    private String addr1;

    private String addr2;

    private String city;

    private String country;

    private int zip;
}
