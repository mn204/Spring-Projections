package com.pp.spring_projections.service.impl;

import com.pp.spring_projections.persistence.projections.PersonFullLocation;
import com.pp.spring_projections.persistence.projections.PersonLocation;
import com.pp.spring_projections.persistence.projections.PersonLocationDTO;
import com.pp.spring_projections.persistence.projections.PersonLocationDTO2;
import com.pp.spring_projections.persistence.repository.PersonRepository;
import com.pp.spring_projections.service.PersonService;
import jakarta.persistence.Tuple;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public PersonFullLocation getPersonFullLocation(Long personId) {
        return personRepository.getPersonFullLocation(personId);
    }

    @Override
    public PersonLocation getPersonLocation(Long personId) {
        return personRepository.getPersonLocation(personId);
    }

    @Override
    public PersonLocationDTO getPersonLocationDTO(Long personId) {
        Tuple tuple = personRepository.getPersonLocationDTO(personId);
        return new PersonLocationDTO(
                tuple.get(0, String.class),
                tuple.get(1, String.class),
                tuple.get(2, String.class)
        );
    }

    @Override
    public PersonLocationDTO2 getPersonLocationDTO2(Long personId) {
        return personRepository.getPersonLocationDTO2(personId);
    }

    @Override
    public <T> T getPersonLocationDynamically(Long personId, Class<T> projectionType) {
        return personRepository.getPersonLocationDynamically(personId, projectionType);
    }
}