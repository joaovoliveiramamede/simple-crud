package com.simplecrud.backend.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplecrud.backend.domain.model.AddressModel;

@Repository
public interface SpringJpaAddressRepository extends JpaRepository<AddressModel, Long> {
    
}
