package com.simplecrud.backend.domain.mapper;

import org.modelmapper.ModelMapper;

import com.simplecrud.backend.domain.model.DeviceModel;
import com.simplecrud.backend.domain.model.dto.DeviceCreateRequest;
import com.simplecrud.backend.domain.model.dto.DeviceResponse;

public class DeviceMapper {
    
    private static final ModelMapper mapper = new ModelMapper();

    public static DeviceModel convertRequestCreateToEntity(DeviceCreateRequest request) {
        return mapper.map(request, DeviceModel.class);
    }

    public static DeviceResponse convertEntityToResponse(DeviceModel entity) {
        return mapper.map(entity, DeviceResponse.class);
    }

}
