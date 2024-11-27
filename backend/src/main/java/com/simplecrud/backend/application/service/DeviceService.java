package com.simplecrud.backend.application.service;

import org.springframework.stereotype.Service;

import com.simplecrud.backend.adapter.out.persistence.DeviceRepositoryJpa;
import com.simplecrud.backend.application.port.in.DeviceUseCase;
import com.simplecrud.backend.application.port.out.DeviceRepository;
import com.simplecrud.backend.domain.exception.DeviceInternalError;
import com.simplecrud.backend.domain.mapper.DeviceMapper;
import com.simplecrud.backend.domain.model.DeviceModel;
import com.simplecrud.backend.domain.model.dto.DeviceCreateRequest;
import com.simplecrud.backend.domain.model.dto.DeviceResponse;

@Service
public class DeviceService implements DeviceUseCase {

    private final DeviceRepository repositoryJpa;

    public DeviceService(DeviceRepositoryJpa deviceRepositoryJpa) {
        this.repositoryJpa = deviceRepositoryJpa;
    }
    
    @Override
    public DeviceResponse create(DeviceCreateRequest request) throws DeviceInternalError {
        try {
            DeviceModel entity = DeviceMapper.convertRequestCreateToEntity(request);
            DeviceModel responseTemp = this.repositoryJpa.save(entity);
            return DeviceMapper.convertEntityToResponse(responseTemp);
        } catch (Exception error) {
            throw new DeviceInternalError("Internal error to create device", error);
        }
    }
    
}
