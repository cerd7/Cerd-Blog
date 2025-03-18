import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { LoginAuthService } from '../../services/auth/login-auth.service';
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-toolbar',
  imports: 
  [
    RouterModule,
    MatButtonModule,
    MatIconModule,
    CommonModule
  ],
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.scss']
})
export class ToolbarComponent 
{
    title: any;
    isLoggedIn: Observable<boolean>;
    isLoginFailed = false;

  constructor(private authService: LoginAuthService) {
    this.isLoggedIn = this.authService.isAuthenticated$;
  }

  logout() {
    this.authService.logout();
  }
}
