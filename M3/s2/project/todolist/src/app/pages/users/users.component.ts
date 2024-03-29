import { Component } from '@angular/core';
import { iUser } from '../../models/iuser';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrl: './users.component.scss'
})
export class UsersComponent {

  usersArray: iUser[] = [];

  constructor(private userSvc: UserService){
    this.userSvc.$getUsersArray.subscribe((users) => (this.usersArray = users));
  }

}
