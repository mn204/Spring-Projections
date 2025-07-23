package com.pp.spring_projections.persistence.projections;


//basado en clase de proyección, solo un POJO simple

import lombok.Value;

@Value
public class PersonLocationDTO {
    private String name;
    private String phone_number;
    private String street;
}
