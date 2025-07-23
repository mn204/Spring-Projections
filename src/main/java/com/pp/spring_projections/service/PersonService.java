package com.pp.spring_projections.service;

import com.pp.spring_projections.persistence.projections.PersonFullLocation;
import com.pp.spring_projections.persistence.projections.PersonLocation;
import com.pp.spring_projections.persistence.projections.PersonLocationDTO;
import com.pp.spring_projections.persistence.projections.PersonLocationDTO2;

public interface PersonService {

    /**
     * Obtiene la proyección de interfaz abierta de una persona
     * @param personId ID de la persona
     * @return PersonFullLocation con la ubicación completa concatenada
     */
    PersonFullLocation getPersonFullLocation(Long personId);

    /**
     * Obtiene la proyección de interfaz cerrada de una persona
     * @param personId ID de la persona
     * @return PersonLocation con campos específicos
     */
    PersonLocation getPersonLocation(Long personId);

    /**
     * Obtiene la proyección basada en clase usando Tuple
     * @param personId ID de la persona
     * @return PersonLocationDTO construido desde Tuple
     */
    PersonLocationDTO getPersonLocationDTO(Long personId);

    /**
     * Obtiene la proyección usando named query
     * @param personId ID de la persona
     * @return PersonLocationDTO2 desde named query
     */
    PersonLocationDTO2 getPersonLocationDTO2(Long personId);

    /**
     * Obtiene proyección dinámicamente según el tipo especificado
     * @param personId ID de la persona
     * @param projectionType Clase del tipo de proyección deseada
     * @return Objeto del tipo especificado
     */
    <T> T getPersonLocationDynamically(Long personId, Class<T> projectionType);
}