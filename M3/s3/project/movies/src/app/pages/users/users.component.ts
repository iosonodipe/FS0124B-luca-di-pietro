import { Component } from '@angular/core';
import { UsersService } from './users.service';
import { IUser } from '../../models/i-user';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrl: './users.component.scss'
})
export class UsersComponent {

  constructor(private usersSvc: UsersService){
    usersSvc.$users.subscribe(users => this.usersArray = users)
  }

  usersArray: IUser[] = []
}
