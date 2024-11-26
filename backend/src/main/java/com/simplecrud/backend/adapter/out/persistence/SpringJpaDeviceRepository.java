package com.simplecrud.backend.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplecrud.backend.domain.model.DeviceModel;

public interface SpringJpaDeviceRepository extends JpaRepository<DeviceModel, Integer> {}
