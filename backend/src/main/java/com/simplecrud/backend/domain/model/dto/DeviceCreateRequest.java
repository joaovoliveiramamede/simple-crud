package com.simplecrud.backend.domain.model.dto;

public class DeviceCreateRequest {
    private String name;
    private String location;

    public DeviceCreateRequest() {}

    public DeviceCreateRequest(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

}
