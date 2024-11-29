import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DeviceRequest, DeviceResponse } from 'src/app/models/device.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DeviceService {

  constructor(
    private http: HttpClient
  ) { }

  public create(device: DeviceRequest): Observable<DeviceResponse> {
    return this.http.post<DeviceResponse>(`${environment.url_api}`, device);
  }

}
