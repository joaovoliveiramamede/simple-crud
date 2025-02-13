import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient
  ) { }

  public login(credentials: {
    username: string,
    password: string
  }): Observable<any> {
    return this.http.post<any>('http://localhost:8080/auth/login', credentials);
  }

}
