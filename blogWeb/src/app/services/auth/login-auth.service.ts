import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, catchError, mapTo, Observable, of, tap } from 'rxjs';

const BASIC_URL = 'http://localhost:8080/api/login';

@Injectable({
  providedIn: 'root'
})
export class LoginAuthService {
  private isAuthenticated = new BehaviorSubject<boolean>(false);
  isAuthenticated$ = this.isAuthenticated.asObservable();

  constructor(private http: HttpClient) { }

  authLogin(username:string, userPassword:string): Observable<boolean>{
    return this.http.post<{ token: string }>(BASIC_URL, { username, userPassword }).pipe(
      tap(response => {
        localStorage.setItem('token', response.token);
        this.isAuthenticated.next(true); // Armazenar o token JWT no localStorage
      }),
      mapTo(true),
      catchError(error => {
        console.error(error);
        this.isAuthenticated.next(false); // Se ocorrer erro, define como não autenticado
        return of(false);
      })
    );
  }  
    
  logout() {
    localStorage.removeItem('token');
    this.isAuthenticated.next(false); // Define como não autenticado após logout
  }

  // Método para checar se está autenticado
  checkAuth() {
    const token = localStorage.getItem('token');
    this.isAuthenticated.next(!!token); // Se o token existir, está autenticado
  }

}
