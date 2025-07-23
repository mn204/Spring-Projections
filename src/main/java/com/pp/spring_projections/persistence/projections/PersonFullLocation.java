package com.pp.spring_projections.persistence.projections;

import org.springframework.beans.factory.annotation.Value;


// proyeccion abierta
public interface PersonFullLocation {

     @Value("#{target.name + ' ' + target.phoneNumber + ' ' + target.street}")
     String getFullLocation();
}
