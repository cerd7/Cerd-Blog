import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, mapTo, Observable, of, tap } from 'rxjs';

const BASIC_URL = 'http://localhost:8080/api/login';

@Injectable({
  providedIn: 'root'
})
export class LoginAuthService {
  constructor(private http: HttpClient) { }

  authLogin(auth:string): Observable<boolean>{
    return this.http.post<{ token: string }>(BASIC_URL, { auth }).pipe(
      tap(response => {
        localStorage.setItem('token', response.token); // Armazenar o token JWT no localStorage
      }),
      mapTo(true),
      catchError(error => {
        console.error(error);
        return of(false);
      })
    );
  }    
}
