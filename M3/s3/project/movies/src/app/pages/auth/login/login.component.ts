import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ILogin } from '../../../models/i-login';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  loginData:ILogin = {
    email:'',
    password:''
  }

  constructor(
    private authSvc:AuthService,
    private router:Router
    ){}

    signIn(){
      this.authSvc.login(this.loginData)
      .subscribe(data => {
        this.router.navigate(['films-list'])
      })
    }
}
