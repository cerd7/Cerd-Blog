import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, mapTo, Observable, of, tap } from 'rxjs';

const BASIC_URL = 'http://localhost:8080/';

@Injectable({
  providedIn: 'root'
})
export class LoginAuthService {
  constructor(private http: HttpClient) { }

  authLogin(auth:any): Observable<boolean>{
      return this.http.post(BASIC_URL + `api/login`, auth).pipe(
        mapTo(true),
        catchError(error => {
          console.error(error);
          return of(false);
        })
      );
    }
}
