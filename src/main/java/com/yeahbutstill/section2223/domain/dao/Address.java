package com.yeahbutstill.section2223.domain.dao;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = -3359933478506962103L;

    private String street;
    private String city;
    private String country;

}
