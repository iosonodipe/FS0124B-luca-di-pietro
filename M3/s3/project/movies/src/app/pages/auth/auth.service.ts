import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { BehaviorSubject, map, tap, Observable } from 'rxjs';
import { IUser } from '../../models/i-user';
import { environment } from '../../../environments/environment.development';
import { ILogin } from '../../models/i-login';
import { ProfileService } from '../profile/profile.service';
import { UsersService } from '../users/users.service';

type AccessData = {
  accessToken:string,
  user:IUser
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http:HttpClient,
    private router:Router,
    private profileSvc: ProfileService,
    private usersSvc: UsersService
    ) {
      this.restoreUser()
    }

  jwtHelper:JwtHelperService = new JwtHelperService()
  authSubject = new BehaviorSubject<IUser|null>(null);
  user$ = this.authSubject.asObservable()
  isLoggedIn$ = this.user$.pipe(
    map(user => !!user),
    tap(user =>  this.syncIsLoggedIn = user)
    )
  syncIsLoggedIn:boolean = false;
  registerUrl:string = environment.registerUrl
  loginUrl:string = environment.loginUrl

  register(newUser:Partial<IUser>):Observable<AccessData>{
    return this.http.post<AccessData>(this.registerUrl,newUser)
    .pipe(tap(()=> {
      this.usersSvc.getAll().subscribe(users => this.usersSvc.usersSubj.next(users))
    }))
  }

  login(loginData:ILogin):Observable<AccessData>{
    return this.http.post<AccessData>(this.loginUrl,loginData)
    .pipe(tap(data => {

      this.authSubject.next(data.user)
      localStorage.setItem('accessData', JSON.stringify(data))
      this.profileSvc.userSubj.next(data.user)
      this.autoLogout(data.accessToken)

    }))
  }

  logout(){

    this.authSubject.next(null)
    localStorage.removeItem('accessData')
    this.router.navigate(['login'])

  }

  getAccessToken():string{
    const userJson = localStorage.getItem('accessData')
    if(!userJson) return '';

    const accessData:AccessData = JSON.parse(userJson)
    if(this.jwtHelper.isTokenExpired(accessData.accessToken)) return '';

    return accessData.accessToken
  }

  autoLogout(jwt:string){
    const expDate = this.jwtHelper.getTokenExpirationDate(jwt) as Date;
    const expMs = expDate.getTime() - new Date().getTime();


    setTimeout(()=>{
      this.logout()
    },expMs)
  }


  restoreUser(){

    const userJson = localStorage.getItem('accessData')
    if(!userJson) return;

    const accessData:AccessData = JSON.parse(userJson)
    if(this.jwtHelper.isTokenExpired(accessData.accessToken)) return;


    this.authSubject.next(accessData.user)
    this.autoLogout(accessData.accessToken)

  }

  errors(err: any) {
    switch (err.error) {
        case "Email and Password are required":
            return new Error('Email e password obbligatorie');
            break;
        case "Email already exists":
            return new Error('Utente esistente');
            break;
        case 'Email format is invalid':
            return new Error('Email scritta male');
            break;
        case 'Cannot find user':
            return new Error('utente inesistente');
            break;
            default:
        return new Error('Errore');
            break;
    }
  }
}
