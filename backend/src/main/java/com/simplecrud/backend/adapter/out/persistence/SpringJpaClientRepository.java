package com.simplecrud.backend.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplecrud.backend.domain.model.ClientModel;

public interface SpringJpaClientRepository extends JpaRepository<ClientModel, Long> {}