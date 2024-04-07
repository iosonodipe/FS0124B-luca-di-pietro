import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment.development';
import { IUser } from '../../models/i-user';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private http: HttpClient) {
    this.getById(this.userId).subscribe(user => this.userSubj.next(user))
  }

  apiUrl: string = environment.usersUrl
  userSubj = new BehaviorSubject<IUser>({id: 0, firstName: '', lastName: '', email: '', password: '', favorites: []})
  $user = this.userSubj.asObservable()
  accessData = JSON.parse(localStorage.getItem('accessData') || 'null');
  userId : number | null = this.accessData ? this.accessData.user.id : null

  getById(id:number | null){
    return this.http.get<IUser>(this.apiUrl+'/'+id)
  }
}
