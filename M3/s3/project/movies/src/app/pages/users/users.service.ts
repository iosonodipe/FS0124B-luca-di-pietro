import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { environment } from '../../../environments/environment.development';
import { IUser } from '../../models/i-user';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http: HttpClient) {
    this.getAll().subscribe(users => {
      this.usersSubj.next(users)
    })
  }
  usersSubj = new BehaviorSubject<IUser[]>([])
  $users = this.usersSubj.asObservable()
  apiUrl: string = environment.usersUrl

  getAll(): Observable<IUser[]>{
    return this.http.get<IUser[]>(this.apiUrl)
  }
}
