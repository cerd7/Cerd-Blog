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
  loginForm!: FormGroup;

  constructor(
      private formBuilder: FormBuilder,
      private login: LoginAuthService,
      private router: Router,
  ){}

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      userEmail: [null, Validators.required],
      userPassword: [null, Validators.required]
    });
  }
  authLogin(){
    const auth = this.loginForm.value;

    if(this.loginForm.invalid){
      alert("Please fill all required fields!!!");
      return;
    }

    this.login.authLogin(auth).subscribe(res =>{
      console.log(res);
      if(res)
      {
        alert("Login successfully !!!");
        this.router.navigateByUrl("/home-blog");
      }else{
        alert("Set corretly Email or Password !!!");
      }
    }, 
    erro=> {
      alert("Something went wrong!!!")
    })
  }
}
