package com.yeahbutstill.section2223.domain.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = -51774598767120150L;

    private Long id;
    private String firstName;
    private String lastName;

    @JsonProperty("full_name")
    private String fullName;

    @JsonIgnore
    private String password;

    private List<String> hobbies;
    private Address address;

    private Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

}
