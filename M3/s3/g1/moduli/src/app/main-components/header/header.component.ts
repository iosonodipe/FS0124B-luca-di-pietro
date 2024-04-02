import { Component } from '@angular/core';
import { AuthService } from '../../pages/auth/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {


  constructor(private authSvc: AuthService, private router: Router){}

  logOut(){
    this.authSvc.bool = false
    this.router.navigate(['/'])
  }

  isLoggedIn(){
    return this.authSvc.isLoggedIn()
  }


}
