import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  bool: boolean = false

  isLoggedIn():boolean{
    return this.bool
  }
}
