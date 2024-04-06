import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { BehaviorSubject, map, tap, Observable } from 'rxjs';
import { IUser } from '../../models/i-user';
import { environment } from '../../../environments/environment.development';
import { ILogin } from '../../models/i-login';

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
    private router:Router
    ) {
      this.restoreUser()
    }

  jwtHelper:JwtHelperService = new JwtHelperService()
  authSubject = new BehaviorSubject<IUser|null>(null);//se nel behavioursubject c'è null significa che l'utente non è loggato, altrimenti conterrà l'oggetto user con tutte le sue info
  user$ = this.authSubject.asObservable()//contiene i dati dell'utente loggato oppure null
  isLoggedIn$ = this.user$.pipe(
    map(user => !!user),
    tap(user =>  this.syncIsLoggedIn = user)
    )//restituisce true se lò'utente è loggato, false se non lo è
  //!!user è come scrivere Boolean(user)
  //isLoggedIn$ = this.user$.pipe(map(user => Boolean(user)))
  syncIsLoggedIn:boolean = false;
  registerUrl:string = environment.registerUrl
  loginUrl:string = environment.loginUrl

  register(newUser:Partial<IUser>):Observable<AccessData>{
    return this.http.post<AccessData>(this.registerUrl,newUser)
  }

  login(loginData:ILogin):Observable<AccessData>{
    return this.http.post<AccessData>(this.loginUrl,loginData)
    .pipe(tap(data => {

      this.authSubject.next(data.user)//comunico al subject che l'utente si è loggato
      localStorage.setItem('accessData', JSON.stringify(data))

      this.autoLogout(data.accessToken)

    }))
  }

  logout(){

    this.authSubject.next(null)//comunico al subject che l'utente si è sloggato
    localStorage.removeItem('accessData')//cancello i dati dell'utente

    this.router.navigate(['login'])//mando via l'utente loggato

  }

  getAccessToken():string{
    const userJson = localStorage.getItem('accessData')//recupero io dati di accesso
    if(!userJson) return ''; //se l'utente non si è mai loggato blocca tutto

    const accessData:AccessData = JSON.parse(userJson)//se viene eseguita questa riga significa che i dati ci sono, quindi la converto da json ad oggetto per permetterne la manipolazione
    if(this.jwtHelper.isTokenExpired(accessData.accessToken)) return ''; //ora controllo se il token è scaduto, se lo è fermiamo la funzione

    return accessData.accessToken
  }

  autoLogout(jwt:string){
    const expDate = this.jwtHelper.getTokenExpirationDate(jwt) as Date;//trovo la data di scadenza del token
    const expMs = expDate.getTime() - new Date().getTime(); //sottraggo i ms della data/ora di oggi da quella nel jwt

    //avvio un timer, quando sarà passato il numero di ms necessari per la scadenza del token, avverrà il logout
    setTimeout(()=>{
      this.logout()
    },expMs)
  }


  restoreUser(){

    const userJson = localStorage.getItem('accessData')//recupero io dati di accesso
    if(!userJson) return; //se l'utente non si è mai loggato blocca tutto

    const accessData:AccessData = JSON.parse(userJson)//se viene eseguita questa riga significa che i dati ci sono, quindi la converto da json ad oggetto per permetterne la manipolazione
    if(this.jwtHelper.isTokenExpired(accessData.accessToken)) return; //ora controllo se il token è scaduto, se lo è fermiamo la funzione

//se nessun return viene eseguito proseguo
    this.authSubject.next(accessData.user)//invio i dati dell'utente al behaviorsubject
    this.autoLogout(accessData.accessToken)//riavvio il timer per la scadenza della sessione

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
