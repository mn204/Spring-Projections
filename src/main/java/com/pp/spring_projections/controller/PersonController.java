package com.pp.spring_projections.controller;

import com.pp.spring_projections.persistence.projections.PersonFullLocation;
import com.pp.spring_projections.persistence.projections.PersonLocation;
import com.pp.spring_projections.persistence.projections.PersonLocationDTO;
import com.pp.spring_projections.persistence.projections.PersonLocationDTO2;
import com.pp.spring_projections.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/interface_open")
    public PersonFullLocation getSampleInterfaceOpenProjection() {
        return personService.getPersonFullLocation(2L);
    }

    @GetMapping("/interface_closed")
    public PersonLocation getSampleInterfaceCloseProjection() {
        return personService.getPersonLocation(2L);
    }

    @GetMapping("/class_based")
    public PersonLocationDTO getSampleClassBasedProjection() {
        return personService.getPersonLocationDTO(2L);
    }

    @GetMapping("/class_based_named_query")
    public PersonLocationDTO2 getSampleClassBasedNqProjection() {
        return personService.getPersonLocationDTO2(2L);
    }

    @GetMapping("/dynamically")
    public Object getSampleClassBasedDinamically() {
        return personService.getPersonLocationDynamically(2L, PersonLocation.class);
    }
}