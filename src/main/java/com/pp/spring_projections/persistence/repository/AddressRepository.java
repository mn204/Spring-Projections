package com.pp.spring_projections.persistence.repository;


import com.pp.spring_projections.persistence.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
