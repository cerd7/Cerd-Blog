import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { BackgroundComponent } from "./components/background/background.component";
import { LoginAuthService } from './services/auth/login-auth.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  imports: [
    RouterOutlet,
    BackgroundComponent
],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
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
