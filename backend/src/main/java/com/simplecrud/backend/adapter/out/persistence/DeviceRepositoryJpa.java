package com.simplecrud.backend.adapter.out.persistence;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.simplecrud.backend.application.port.out.DeviceRepository;
import com.simplecrud.backend.domain.exception.DeviceTransactionalError;
import com.simplecrud.backend.domain.model.DeviceModel;

import jakarta.transaction.Transactional;

@Service
public class DeviceRepositoryJpa implements DeviceRepository {

    private final SpringJpaDeviceRepository springJpaRepository;

    public DeviceRepositoryJpa(SpringJpaDeviceRepository repositoryJpa) {
        this.springJpaRepository = repositoryJpa;
    }

    @Override
    @Transactional
    public DeviceModel save(DeviceModel device) throws DeviceTransactionalError {
        try {
            DeviceModel response = this.springJpaRepository.save(device);
            return response;
        } catch (DataAccessException error) {
            throw new DeviceTransactionalError("Error to connect with database", error);
        }
    }
    
}
