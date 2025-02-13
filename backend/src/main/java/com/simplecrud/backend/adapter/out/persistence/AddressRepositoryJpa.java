package com.simplecrud.backend.adapter.out.persistence;

import org.springframework.stereotype.Service;

import com.simplecrud.backend.application.port.out.AddressRepository;
import com.simplecrud.backend.domain.model.AddressModel;

@Service
public class AddressRepositoryJpa implements AddressRepository {

    private final SpringJpaAddressRepository repository;

    public AddressRepositoryJpa(
        SpringJpaAddressRepository springJpaAddressRepository
    ) {
        this.repository = springJpaAddressRepository;
    }

    @Override
    public AddressModel save(AddressModel entity) {
        return this.repository.save(entity);
    }

    

}
