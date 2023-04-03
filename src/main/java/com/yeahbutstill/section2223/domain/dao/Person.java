package com.yeahbutstill.section2223.domain.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {


    @Serial
    private static final long serialVersionUID = -51774598767120150L;

    private Long id;
    private String name;
    private List<String> hobbies;
    private Address address;
}
