export interface DeviceResponse {
    name: string;
    location: string;
}

export class DeviceRequest {
    name: string;
    location: string;

    constructor(
        name: string, 
        location: string
    ) {
        this.name = name;
        this.location = location;
    }
}