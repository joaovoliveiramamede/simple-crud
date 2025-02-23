package com.simplecrud.backend.adapter.out.persistence.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplecrud.backend.domain.model.ProviderModel;

@Repository
public interface SpringProviderJpa extends JpaRepository<ProviderModel, Long> {
    
}
