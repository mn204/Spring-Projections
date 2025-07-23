package com.pp.spring_projections.persistence.repository;


import com.pp.spring_projections.persistence.entity.Person;
import com.pp.spring_projections.persistence.projections.PersonFullLocation;
import com.pp.spring_projections.persistence.projections.PersonLocation;
import com.pp.spring_projections.persistence.projections.PersonLocationDTO2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.persistence.Tuple;


public interface PersonRepository extends JpaRepository<Person, Long> {

    // usando una interfaz de proyeccion cerrada
    @Query(value = "SELECT " +
            " P.NAME as name," +
            " P.PHONE_NUMBER AS phoneNumber, " +
            " A.STREET AS street " +
            " FROM PERSON P " +
            " INNER JOIN ADDRESS A ON A.ID = P.ADDRESS_ID " +
            " WHERE P.ID = :id", nativeQuery = true)
    public PersonLocation getPersonLocation(@Param("id") Long personId);

    // usando una interfaz de proyeccion abierta
    @Query(value = "SELECT " +
            " P.NAME as name," +
            " P.PHONE_NUMBER AS phoneNumber, " +
            " A.STREET AS street " +
            " FROM PERSON P " +
            " INNER JOIN ADDRESS A ON A.ID = P.ADDRESS_ID " +
            " WHERE P.ID = :id", nativeQuery = true)
    public PersonFullLocation getPersonFullLocation(@Param("id") Long personId);


    // usando basado en clase
    @Query(value = "SELECT " +
            " P.NAME as name," +
            " P.PHONE_NUMBER AS phoneNumber, " +
            " A.STREET AS street " +
            " FROM PERSON P " +
            " INNER JOIN ADDRESS A ON A.ID = P.ADDRESS_ID " +
            " WHERE P.ID = :id",
            nativeQuery = true)
    public Tuple getPersonLocationDTO(@Param("id") Long personId);


    // usando basado en querry
    @Query(name = "getPersonLocationDTONamingQuery", nativeQuery = true)
    public PersonLocationDTO2 getPersonLocationDTO2(@Param("id") Long personId);


    // aca es dinamico
    @Query(value = "SELECT " +
            " P.NAME as name," +
            " P.PHONE_NUMBER AS phoneNumber, " +
            " A.STREET AS street " +
            " FROM PERSON P " +
            " INNER JOIN ADDRESS A ON A.ID = P.ADDRESS_ID " +
            " WHERE P.ID = :id", nativeQuery = true)
    <T> T getPersonLocationDynamically(@Param("id") Long personId, Class<T> type);
}
