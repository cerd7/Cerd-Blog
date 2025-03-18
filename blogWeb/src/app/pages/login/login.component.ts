import { ChangeDetectorRef, Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginAuthService } from '../../services/auth/login-auth.service';
import { ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: 
  [
    CommonModule,
    ReactiveFormsModule,
    FormsModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent 
{
  username:string = '';
  userPassword: string = '';
  isLoginFailed = false;

  constructor(
      private formBuilder: FormBuilder,
      private login: LoginAuthService,
      private router: Router,
  ){}

  authLogin(){
    this.login.authLogin(this.username, this.userPassword).subscribe(isAuthenticated =>{
      console.log(isAuthenticated);
      if(isAuthenticated)
      {
        this.isLoginFailed = false;
        alert("Login successfully !!!");
        this.router.navigateByUrl("/home-blog");
      }else{
        this.isLoginFailed = true;
        alert("Set corretly Email or Password !!!");
      }
    }, 
    erro=> {
      alert("Something went wrong!!!")
    })
  }
}
