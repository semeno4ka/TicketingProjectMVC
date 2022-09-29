package com.cydeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    private Long id;
    private String description;// imagine an excel sheet with a table where is a ROLE table that is why separate class required

}
