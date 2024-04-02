import { Component, ElementRef, ViewChild } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
})
export class LoginComponent {
  @ViewChild('email') email!: ElementRef;
  @ViewChild('password') password!: ElementRef;

  constructor(private authSvc: AuthService, private router: Router) {}

  filledInputs: boolean = false;

  logIn() {
    if (
      this.email.nativeElement.value != '' &&
      this.password.nativeElement.value != ''
    ) {
      this.authSvc.bool = true;
      this.router.navigate(['/pagina2'])

    } else this.filledInputs = true;
  }
}
