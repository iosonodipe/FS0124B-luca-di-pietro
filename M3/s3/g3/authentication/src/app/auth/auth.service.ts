import { Injectable } from '@angular/core';
import { IUser } from '../models/i-user';
import { JwtHelperService } from '@auth0/angular-jwt';
import { BehaviorSubject, Observable, map, tap } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { environment } from '../../environments/environment.development';
import { ILogin } from '../models/i-login';

type AccessData = {
  accessToken: string,
  user: IUser
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  jwt: JwtHelperService = new JwtHelperService()

  authSubj = new BehaviorSubject<IUser|null>(null)
  $user = this.authSubj.asObservable()
  $isLoggedIn = this.$user.pipe(map(user => !!user))
  registerUrl: string = environment.registerUrl
  loginUrl: string = environment.loginUrl

  constructor(private http: HttpClient, private router: Router) { }

  register(user: Partial<IUser>):Observable<AccessData>{
    return this.http.post<AccessData>(this.registerUrl, user)
  }

  login(login:ILogin):Observable<AccessData>{
    return this.http.post<AccessData>(this.loginUrl, login)
    .pipe(tap(data => {
      this.authSubj.next(data.user)
      localStorage.setItem('accessData', JSON.stringify(data))
    }))
  }

}
