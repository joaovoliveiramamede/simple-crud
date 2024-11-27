package com.simplecrud.backend.adapter.in.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplecrud.backend.application.port.in.DeviceUseCase;
import com.simplecrud.backend.application.service.DeviceService;
import com.simplecrud.backend.domain.model.dto.DeviceCreateRequest;
import com.simplecrud.backend.domain.model.dto.DeviceResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "device")
public class DeviceRestController {
    
    private final DeviceUseCase command;

    public DeviceRestController(DeviceService service) {
        this.command = service;
    }


    @PostMapping("create")
    public DeviceResponse create(@RequestBody DeviceCreateRequest request) {
        DeviceResponse response = this.command.create(request);
        return response;
    }
    
}
